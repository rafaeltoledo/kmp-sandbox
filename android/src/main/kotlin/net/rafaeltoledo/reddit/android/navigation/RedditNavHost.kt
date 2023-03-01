package net.rafaeltoledo.reddit.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import net.rafaeltoledo.reddit.android.feature.subreddit.navigation.SubRedditNameArg
import net.rafaeltoledo.reddit.android.feature.subreddit.navigation.subRedditScreen

@Composable
fun RedditNavHost(
  navController: NavHostController,
  modifier: Modifier = Modifier,
  startDestination: String = "r/{$SubRedditNameArg}",
) {
  NavHost(
    navController = navController,
    startDestination = startDestination,
    modifier = modifier,
  ) {
    subRedditScreen()
  }
}
