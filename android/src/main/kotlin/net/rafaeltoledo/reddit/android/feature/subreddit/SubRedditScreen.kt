package net.rafaeltoledo.reddit.android.feature.subreddit

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SubRedditRoute(
  modifier: Modifier = Modifier,
  viewModel: SubRedditViewModel = hiltViewModel(),
) {
  val subRedditUiState: SubRedditUiState by viewModel.subRedditUiState.collectAsStateWithLifecycle()

  SubRedditScreen(
    subRedditUiState = subRedditUiState,
    modifier = modifier,
  )
}

@Composable
fun SubRedditScreen(
  subRedditUiState: SubRedditUiState,
  modifier: Modifier = Modifier,
) {
  when (subRedditUiState) {
    SubRedditUiState.Loading -> {
      CircularProgressIndicator()
    }

    is SubRedditUiState.Success -> {
      Scaffold(
        modifier = modifier,
        topBar = {
          TopAppBar(title = {
            Text(subRedditUiState.subRedditName)
          })
        }
      ) {
        Box(
          modifier = Modifier
            .padding(it),
        )
      }
    }
  }
}
