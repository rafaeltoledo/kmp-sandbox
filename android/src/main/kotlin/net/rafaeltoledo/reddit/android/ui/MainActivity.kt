package net.rafaeltoledo.reddit.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import net.rafaeltoledo.reddit.Platform
import net.rafaeltoledo.reddit.RequestTest
import net.rafaeltoledo.reddit.SerializationTest

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      MaterialTheme {
        Screen()
      }
    }
  }
}

@Composable
fun Screen(scaffoldState: ScaffoldState = rememberScaffoldState()) {

  val scope = rememberCoroutineScope()

  Scaffold(scaffoldState = scaffoldState) {
    Column(modifier = Modifier.padding(it)) {
      Text(text = "${Platform().name()}\n${SerializationTest().canWeSerialize()}")

      Button(
        onClick = {
          // Create a new coroutine in the event handler to show a snackbar
          scope.launch {
            scaffoldState.snackbarHostState.showSnackbar(RequestTest().doRequest()?.toString() ?: "Got an error!")
          }
        }
      ) {
        Text("Press me")
      }
    }
  }
}
