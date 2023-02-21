package net.rafaeltoledo.reddit

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import net.rafaeltoledo.reddit.data.SampleClass

class SerializationTest {

  fun canWeSerialize(): String {
    val sampleJson = """
      {"value": "Some value"}
      """

    val data: SampleClass = Json.decodeFromString(sampleJson)

    return "Can ${Platform().name()} deserialize? ${data.value}"
  }
}
