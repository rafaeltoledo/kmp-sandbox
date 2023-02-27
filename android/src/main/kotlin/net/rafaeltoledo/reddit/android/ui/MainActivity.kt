package net.rafaeltoledo.reddit.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import net.rafaeltoledo.reddit.android.ui.theme.RedditTheme

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    val splashScreen = installSplashScreen()
    super.onCreate(savedInstanceState)

    WindowCompat.setDecorFitsSystemWindows(window, false)

    splashScreen.setKeepOnScreenCondition { false }

    setContent {
      RedditTheme {
        RedditApp()
      }
    }
  }
}
