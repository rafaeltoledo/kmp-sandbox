package net.rafaeltoledo.reddit.android.feature.subreddit

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SubRedditRoute(
  modifier: Modifier = Modifier,
) {
  SubRedditScreen(
    modifier = modifier,
  )
}

@Composable
fun SubRedditScreen(
  modifier: Modifier = Modifier,
) {
  Text(
    "Hello",
    modifier = modifier,
  )
}
