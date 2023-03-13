package net.rafaeltoledo.reddit.api.model

import kotlin.reflect.KClass

enum class RedditKind(val key: String, val kClass: KClass<out RedditObject>) {
  COMMENT("t1", RedditComment::class),
  LINK("t3", RedditLink::class),
  LISTING("Listing", RedditListing::class),
}
