package net.rafaeltoledo.reddit.android.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberRedditAppState(
  coroutineScope: CoroutineScope = rememberCoroutineScope(),
  navController: NavHostController = rememberNavController(),
): RedditAppState {
  return remember(navController, coroutineScope) {
    RedditAppState(navController, coroutineScope)
  }
}

@Stable
class RedditAppState(
  val navController: NavHostController,
  val coroutineScope: CoroutineScope,
)
