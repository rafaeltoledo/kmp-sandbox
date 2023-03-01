package net.rafaeltoledo.reddit.android.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@Composable
fun RedditTheme(
  content: @Composable () -> Unit,
) {
  val colors = lightColors(
    primary = Brand,
  )

  MaterialTheme(
    colors = colors,
    content = content,
  )
}
