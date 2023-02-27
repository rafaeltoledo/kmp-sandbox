package net.rafaeltoledo.reddit.android.feature.subreddit.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import net.rafaeltoledo.reddit.android.feature.subreddit.SubRedditRoute

const val SubRedditRoute = "r"

fun NavController.navigateToSubreddit(subRedditName: String = "frontpage", navOptions: NavOptions? = null) {
  navigate("$SubRedditRoute/$subRedditName", navOptions)
}

fun NavGraphBuilder.subRedditScreen() {
  composable(route = SubRedditRoute) {
    SubRedditRoute()
  }
}
