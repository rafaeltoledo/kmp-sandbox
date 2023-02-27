package net.rafaeltoledo.reddit.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.rafaeltoledo.reddit.android.navigation.RedditNavHost

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RedditApp(
  modifier: Modifier = Modifier,
  appState: RedditAppState = rememberRedditAppState(),
) {
  Scaffold(
    modifier = modifier,
  ) { paddingValues ->
    Row(
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
        .consumedWindowInsets(paddingValues)
        .windowInsetsPadding(
          WindowInsets.safeDrawing.only(
            WindowInsetsSides.Horizontal,
          ),
        ),
    ) {
      Column(Modifier.fillMaxSize()) {
        RedditNavHost(appState.navController)
      }
    }
  }
}
