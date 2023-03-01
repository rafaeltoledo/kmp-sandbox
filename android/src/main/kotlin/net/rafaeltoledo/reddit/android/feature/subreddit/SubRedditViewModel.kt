package net.rafaeltoledo.reddit.android.feature.subreddit

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import net.rafaeltoledo.reddit.android.feature.subreddit.navigation.SubRedditArgs
import javax.inject.Inject

@HiltViewModel
class SubRedditViewModel @Inject constructor(
  savedStateHandle: SavedStateHandle,
) : ViewModel() {

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
    return flowOf(
      SubRedditUiState.Success(
        subRedditName,
        listOf( // Mock data
          "Dave Grohl showed up with no publicity to cook and serve for 500 people at Hope Mission in L.A.",
          "When people make fun of me watching twitch I show them this...",
          "Finland begins building \$597 million barbed wire fence on Russian border",
          "Florida Republicans introduce a bill to eliminate the Democratic Party.",
          "Triple bacon - Day 99",
          "Amy Coney Barrett joins liberal Supreme Court justices in scrutinizing a student-loan company's " +
            "involvement in one of the lawsuits blocking Biden's debt relief",
          "TIL that “Stranger Things” star Winona Ryder pushed for Kate Bush’s song “Running Up That Hill” to " +
            "be featured on the show. Ryder also stated that for seven years, she dropped hints on the show’s " +
            "set by wearing her Kate Bush t-shirts. Winona’s plan eventually worked.",
          "Born today. Both parents are white as snow.",
          "This Japanese restaurant has a waxwork samurai in the urinals",
          "to get a snack",
          "Brendan Fraser posing with his SAG award. Taken from his IG.",
          "Starbucks told us there were no pup cups today. (OC).",
          "This man has nurtured a turtle with an exposed heart to ensure she survives and thrives (3:31)",
          "Dave Grohl spent 16 hours in a storm BBQing for the homeless in LA",
          "me irl",
          "Woman is detained for wearing a bikini on a beach",
        ),
      )
    )
  }
}

sealed interface SubRedditUiState {
  data class Success(val subRedditName: String, val comments: List<String>) : SubRedditUiState
  object Loading : SubRedditUiState
}
