package net.rafaeltoledo.reddit.api.model

import kotlinx.serialization.Serializable
import net.rafaeltoledo.reddit.data.RedditObjectSerializer

@Serializable(with = RedditObjectSerializer::class)
sealed interface RedditObject

@Serializable
data class RedditListing(
  val after: String,
  val before: String?,
  val dist: Int,
  val modhash: String,
  val children: List<RedditObject>,
) : RedditObject

@Serializable
data class RedditComment(
  val body: String,
) : RedditObject

@Serializable
data class RedditLink(
  val clicked: Boolean,
  val subreddit: String,
  val title: String,
) : RedditObject
