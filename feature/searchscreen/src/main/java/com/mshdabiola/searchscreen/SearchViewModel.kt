package com.mshdabiola.searchscreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mshdabiola.data.repository.NetworkRepository
import com.mshdabiola.ui.colors
import com.mshdabiola.ui.data.GenreUiState
import com.mshdabiola.ui.data.toTrackUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val networkRepository: NetworkRepository
) : ViewModel() {

    private val _searchUiState = MutableStateFlow(SearchUiState())
    val searchUiState = _searchUiState.asStateFlow()

    private var job: Job? = null

    init {
        viewModelScope.launch {
            val rand = Random(4)
            val genre = listOf(
                "acoustic",
                "afrobeat",
                "alt-rock",
                "alternative",
                "ambient",
                "anime",
                "black-metal",
                "bluegrass",
                "blues",
                "bossanova",
                "brazil",
                "breakbeat",
                "british",
                "cantopop",
                "chicago-house",
                "children",
                "chill",
                "classical",
                "club",
                "comedy",
                "country",
                "dance",
                "dancehall",
                "death-metal",
                "deep-house",
                "detroit-techno",
                "disco",
                "disney",
                "drum-and-bass",
                "dub",
                "dubstep",
                "edm",
                "electro",
                "electronic",
                "emo",
                "folk",
                "forro",
                "french",
                "funk",
                "garage",
                "german",
                "gospel",
                "goth",
                "grindcore",
                "groove",
                "grunge",
                "guitar",
                "happy",
                "hard-rock",
                "hardcore",
                "hardstyle",
                "heavy-metal",
                "hip-hop",
                "holidays",
                "honky-tonk",
                "house",
                "idm",
                "indian",
                "indie",
                "indie-pop",
                "industrial",
                "iranian",
                "j-dance",
                "j-idol",
                "j-pop",
                "j-rock",
                "jazz",
                "k-pop",
                "kids",
                "latin",
                "latino",
                "malay",
                "mandopop",
                "metal",
                "metal-misc",
                "metalcore",
                "minimal-techno",
                "movies",
                "mpb",
                "new-age",
                "new-release",
                "opera",
                "pagode",
                "party",
                "philippines-opm",
                "piano",
                "pop",
                "pop-film",
                "post-dubstep",
                "power-pop",
                "progressive-house",
                "psych-rock",
                "punk",
                "punk-rock",
                "r-n-b",
                "rainy-day",
                "reggae",
                "reggaeton",
                "road-trip",
                "rock",
                "rock-n-roll",
                "rockabilly",
                "romance",
                "sad",
                "salsa",
                "samba",
                "sertanejo",
                "show-tunes",
                "singer-songwriter",
                "ska",
                "sleep",
                "songwriter",
                "soul",
                "soundtracks",
                "spanish",
                "study",
                "summer",
                "swedish",
                "synth-pop",
                "tango",
                "techno",
                "trance",
                "trip-hop",
                "turkish",
                "work-out",
                "world-music"
            )
                .shuffled()
                .take(17)
                .mapIndexed { index, s ->
                    GenreUiState(id = index, color = rand.nextInt(colors.size), name = s)
                }
                .toImmutableList()

            _searchUiState.update {
                it.copy(genres = genre)
            }


        }
    }


    fun search(query: String) {

        if (query.length > 3) {
            job?.cancel()
            job = viewModelScope.launch {
                networkRepository.search(query, "track")
                    .onSuccess { list ->
                        _searchUiState.update { searchUiState1 ->
                            searchUiState1.copy(tracks = list.map { it.toTrackUiState() }
                                .toImmutableList())
                        }
                    }
                    .onFailure {
                        Timber.e(it)
                    }


            }
        }
    }
}