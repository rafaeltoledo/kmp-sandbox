package net.rafaeltoledo.reddit.android.feature.subreddit.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import net.rafaeltoledo.reddit.android.feature.subreddit.SubRedditRoute

const val SubRedditNameArg = "subRedditName"
private const val DefaultSubReddit = "all"

class SubRedditArgs(val subRedditName: String) {
  constructor(savedStateHandle: SavedStateHandle) :
    this(checkNotNull(savedStateHandle[SubRedditNameArg]) as String)
}

fun NavController.navigateToSubreddit(subRedditName: String) {
  navigate("r/$subRedditName")
}

fun NavGraphBuilder.subRedditScreen() {
  composable(
    route = "r/{$SubRedditNameArg}",
    arguments = listOf(
      navArgument(SubRedditNameArg) { type = NavType.StringType; defaultValue = DefaultSubReddit }
    )
  ) {
    SubRedditRoute()
  }
}
