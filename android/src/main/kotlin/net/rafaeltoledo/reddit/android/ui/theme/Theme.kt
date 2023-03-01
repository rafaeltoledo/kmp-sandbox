package net.rafaeltoledo.reddit.android.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

@Composable
fun RedditTheme(
  content: @Composable () -> Unit,
) {
  val colorScheme = lightColorScheme(
    primary = Brand,
  )

  val typography = Typography()

  MaterialTheme(
    colorScheme = colorScheme,
    typography = typography,
    content = content,
  )
}
