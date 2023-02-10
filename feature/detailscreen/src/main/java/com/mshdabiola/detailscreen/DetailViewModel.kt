package com.mshdabiola.detailscreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mshdabiola.data.repository.NetworkRepository
import com.mshdabiola.ui.data.ArtistUiState
import com.mshdabiola.ui.data.toPlaylistUiState
import com.mshdabiola.ui.data.toTrackUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
 internal class DetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val networkRepository: NetworkRepository
) : ViewModel() {

    val detailArg=DetailArg(savedStateHandle)

    private val _detailState = MutableStateFlow(DetailState().copy( artists = listOf(ArtistUiState(
        id = "Carlita",
        name = "Ernestina",
        image = "Tonja",
        type = "Shaquanda"
    )).toImmutableList()))
    val detailState= _detailState.asStateFlow()

    init {

        viewModelScope.launch {
            delay(100)
          //  Timber.e("id")
            when(detailArg.type){
                "track"->{
                  networkRepository.getTrack(detailArg.id)
                      .onSuccess {
                          Timber.e(it.toString())
                          val time =Instant.fromEpochMilliseconds(it.releaseDate).toLocalDateTime(
                              TimeZone.UTC)
                          _detailState.update { det->
                              det.copy(
                                  image = it.image,
                                  title = it.name,

                                  subTitle = "Single * ${time.year}",
                                  date = "${time.month.name} ${time.dayOfMonth}, ${time.year}",
                                  trackList = listOf(it.toTrackUiState()).toImmutableList()
                              )
                          }
                      }
                      .onFailure {
                          Timber.e(it)
                      }


                }

                "album"->{
                    networkRepository.getAlbum(detailArg.id)
                        .onSuccess {
                            val time =Instant.fromEpochMilliseconds(it.releaseDate).toLocalDateTime(
                                TimeZone.UTC)
                            _detailState.update { det->
                                det.copy(
                                    image = it.imageUri,
                                    title = it.name,
                                    subTitle = "Single * ${time.year}",
                                    date = "${time.month.name} ${time.dayOfMonth}, ${time.year}",
                                    trackList = it.tracks.map { it.toTrackUiState() }.toImmutableList()
                                )
                            }
                        }
                        .onFailure {
                            Timber.e(it)
                        }


                }
            }
        }

        viewModelScope.launch {
            networkRepository.getFeaturePlaylist()
                .onSuccess {
                    _detailState
                        .update { detailState ->
                            detailState.copy(playList = it.map { it.toPlaylistUiState() }.toImmutableList()
                            )
                        }
                }
                .onFailure {
                    Timber.e(it)
                }
        }
    }

}