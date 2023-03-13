package net.rafaeltoledo.reddit.android.feature.subreddit

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import net.rafaeltoledo.reddit.android.feature.subreddit.navigation.SubRedditArgs
import net.rafaeltoledo.reddit.api.RedditClient
import net.rafaeltoledo.reddit.api.model.RedditObject
import javax.inject.Inject

@HiltViewModel
class SubRedditViewModel @Inject constructor(
  savedStateHandle: SavedStateHandle,
) : ViewModel() {

  private val client = RedditClient()
  private val subRedditArgs: SubRedditArgs = SubRedditArgs(savedStateHandle)

  val subRedditUiState: StateFlow<SubRedditUiState> = subRedditUiState(
    subRedditName = subRedditArgs.subRedditName,
  ).stateIn(
    scope = viewModelScope,
    started = SharingStarted.WhileSubscribed(5_000),
    initialValue = SubRedditUiState.Loading,
  )

  private fun subRedditUiState(
    subRedditName: String,
  ): Flow<SubRedditUiState> {
    return flow {
      emit(SubRedditUiState.Success(subRedditName, client.subreddit(subRedditName).children))
    }
  }
}

sealed interface SubRedditUiState {
  data class Success(val subRedditName: String, val comments: List<RedditObject>) : SubRedditUiState
  object Loading : SubRedditUiState
}
