package net.rafaeltoledo.reddit.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import net.rafaeltoledo.reddit.Platform
import net.rafaeltoledo.reddit.SerializationTest

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      MaterialTheme {
        Text(text = "${Platform().name()}\n${SerializationTest().canWeSerialize()}")
      }
    }
  }
}
