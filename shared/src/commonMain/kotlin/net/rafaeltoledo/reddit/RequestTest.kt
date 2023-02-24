package net.rafaeltoledo.reddit

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import io.ktor.utils.io.core.use
import net.rafaeltoledo.reddit.data.SampleResponse

class RequestTest {

  suspend fun doRequest(): SampleResponse? {
    val response: HttpResponse = HttpClient(CIO) {
      install(ContentNegotiation) {
        json()
      }
    }.use {
      it.get(TEST_URL)
    }

    return if (response.status.isSuccess()) {
      response.body()
    } else {
      null
    }
  }

  companion object {
    private const val TEST_URL = "https://jsonplaceholder.typicode.com/todos/1"
  }
}
