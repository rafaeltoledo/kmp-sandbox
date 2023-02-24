package net.rafaeltoledo.reddit.data

import kotlinx.serialization.Serializable

@Serializable
data class SampleResponse(
  val userId: Long,
  val id: Long,
  val title: String,
  val completed: Boolean,
)
