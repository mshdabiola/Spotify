package com.mshdabiola.mainscreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mshdabiola.data.repository.ModelRepository
import com.mshdabiola.data.repository.NetworkRepository
import com.mshdabiola.ui.data.toAlbumUiState
import com.mshdabiola.ui.data.toArtistUiState
import com.mshdabiola.ui.data.toCategoryUiState
import com.mshdabiola.ui.data.toPlaylistUiState
import com.mshdabiola.ui.data.toTrackUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(
    //private val savedStateHandle: SavedStateHandle,
   // private val modelRepository: ModelRepository,
    private val networkRepository: NetworkRepository
) : ViewModel() {

    private val _mainState= MutableStateFlow(MainState())
    val mainState=_mainState.asStateFlow()
    init {
        viewModelScope.launch {

            networkRepository
                .getNewRelease()
               .onSuccess { albumList ->
                   val value=  albumList.map { it.toAlbumUiState() }
               .toImmutableList()
            Timber.e(albumList.joinToString())
            _mainState.update {

                it.copy(newRelease = value)
            }
               }
               .onFailure {

                   Timber.e(t = it,message = "failure")

               }

//
        }

        viewModelScope.launch {

            networkRepository
                .getRecommendation()
                .onSuccess { albumList ->
                    val value=  albumList.map { it.toTrackUiState()}
                        .toImmutableList()
                    Timber.e(albumList.joinToString())
                    _mainState.update {

                        it.copy(recommendations = value)
                    }
                }
                .onFailure {

                    Timber.e(t = it,message = "failure")

                }

//
        }

        viewModelScope.launch {
            networkRepository
                .getCategory()
                .onSuccess { list->
                   _mainState.update { mainState1 ->
                       mainState1.copy(category = list.map { it.toCategoryUiState() }.toImmutableList())
                   }
                }
                .onFailure {
                    Timber.e(it)
                }
        }

        viewModelScope.launch {
            networkRepository
                .getFeaturePlaylist()
                .onSuccess { playlist->
                    _mainState.update { mainState1 ->
                        mainState1.copy(featurePlaylist = playlist.map { it.toPlaylistUiState() }.toImmutableList())
                    }
                }
                .onFailure {
                    Timber.e(it)
                }
        }

        viewModelScope.launch {
            networkRepository
                .getArtiste()
                .onSuccess { artists ->
                    _mainState.update {
                        it.copy(relatedArtiste =artists.map { it.toArtistUiState() }.toImmutableList())
                    }
                }
        }
    }

}
