package net.rafaeltoledo.reddit.data

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.serializer
import net.rafaeltoledo.reddit.api.model.RedditKind
import net.rafaeltoledo.reddit.api.model.RedditObject

@OptIn(InternalSerializationApi::class)
class RedditObjectSerializer : KSerializer<RedditObject> {

  override val descriptor: SerialDescriptor = RedditObjectSurrogate.serializer().descriptor

  override fun deserialize(decoder: Decoder): RedditObject {
    if (decoder is JsonDecoder) {
      decoder.decodeJsonElement().let { jsonElement ->
        val rawKind = jsonElement.jsonObject["kind"]?.jsonPrimitive?.content
        val kind = RedditKind.values().find { it.key == rawKind }
          ?: error("Unexpected Reddit API object: $rawKind")

        val rawData: JsonElement = jsonElement.jsonObject["data"]
          ?: error("Cannot find data key in the JSON!")
        return decoder.json.decodeFromJsonElement(kind.kClass.serializer(), rawData)
      }
    }

    throw UnsupportedOperationException("Unexpected serialization format. Only JSON is supported!")
  }

  override fun serialize(encoder: Encoder, value: RedditObject) {
    TODO()
  }
}

@Serializable
data class RedditObjectSurrogate(
  val kind: RedditKind,
  val data: RedditObject,
)
