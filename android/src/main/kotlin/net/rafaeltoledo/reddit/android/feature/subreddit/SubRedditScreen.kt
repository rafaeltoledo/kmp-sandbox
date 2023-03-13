package net.rafaeltoledo.reddit.android.feature.subreddit

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import net.rafaeltoledo.reddit.api.model.RedditLink
import net.rafaeltoledo.reddit.api.model.RedditObject

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

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun SubRedditScreen(
  subRedditUiState: SubRedditUiState,
  modifier: Modifier = Modifier,
) {
  when (subRedditUiState) {
    SubRedditUiState.Loading -> {
      Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
      ) {
        CircularProgressIndicator()
      }
    }

    is SubRedditUiState.Success -> {
      Column(modifier = modifier) {
        CenterAlignedTopAppBar(
          modifier = Modifier,
          title = {
            Text(subRedditUiState.subRedditName)
          },
        )
        LazyColumn {
          items(subRedditUiState.comments) {
            ListItem(
              text = { Text(it.title()) }
            )
          }
        }
      }
    }
  }
}

private fun RedditObject.title(): String {
  return when (this) {
    is RedditLink -> this.title
    else -> ""
  }
}
