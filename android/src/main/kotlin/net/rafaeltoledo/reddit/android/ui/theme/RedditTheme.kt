package net.rafaeltoledo.reddit.android.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun RedditTheme(
  content: @Composable () -> Unit,
) {
  MaterialTheme(
    content = content,
  )
}
