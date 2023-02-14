package com.mshdabiola.libraryscreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mshdabiola.data.repository.NetworkRepository
import com.mshdabiola.ui.data.toAlbumUiState
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
class LibraryViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val networkRepository: NetworkRepository
) : ViewModel() {

    private val _libraryUiState = MutableStateFlow(LibraryUiState())
    val libraryUiState = _libraryUiState.asStateFlow()


    init {
        viewModelScope.launch {
            networkRepository
                .getUserAlbums()
                .onSuccess { list ->
                    _libraryUiState
                        .update {
                            it.copy(userAlbums = list.map { it.toAlbumUiState() }.toImmutableList())
                        }
                }
                .onFailure {
                    Timber.e(it)
                }
        }

        viewModelScope.launch {
            networkRepository
                .getUserTracks()
                .onSuccess { list ->
                    _libraryUiState
                        .update {
                            it.copy(userTracks = list.map { it.toTrackUiState() }.toImmutableList())
                        }
                }
                .onFailure {
                    Timber.e(it)
                }
        }
    }


}