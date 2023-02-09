package net.rafaeltoledo.reddit.android.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import net.rafaeltoledo.reddit.Platform

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    Log.d("RedditApp", Platform().name())
  }
}
