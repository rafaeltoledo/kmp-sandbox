package net.rafaeltoledo.reddit.api

import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import net.rafaeltoledo.reddit.api.model.RedditComment
import net.rafaeltoledo.reddit.api.model.RedditLink
import net.rafaeltoledo.reddit.api.model.RedditListing
import net.rafaeltoledo.reddit.api.model.RedditObject

class RedditClient {

  private val httpClient: HttpClient = buildHttpClient()

  suspend fun subreddit(subreddit: String): RedditListing {
    val response = httpClient.get("${API_HOST}/r/$subreddit/hot.json") {
      contentType(ContentType.Application.Json)
    }

    if (response.status.isSuccess()) {
      val body: RedditObject = response.body()
      return body as RedditListing
    }

    error("Request failed with (${response.status})")
  }

  private companion object {
    const val API_HOST = "https://api.reddit.com"
  }
}

private fun buildHttpClient(json: Json = buildJson()): HttpClient {
  return HttpClient {
    install(ContentNegotiation) {
      json(json)
    }

    install(Logging) {
      logger = Logger.DEFAULT
      level = LogLevel.BODY
    }
  }
}

private fun buildJson(): Json {
  val redditModule = SerializersModule {
    polymorphic(RedditObject::class) {
      subclass(RedditListing::class, RedditListing.serializer())
      subclass(RedditComment::class, RedditComment.serializer())
      subclass(RedditLink::class, RedditLink.serializer())
    }
  }

  return Json {
    ignoreUnknownKeys = true
    serializersModule = redditModule
  }
}
