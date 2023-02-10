package com.mshdabiola.detailscreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mshdabiola.data.repository.NetworkRepository
import com.mshdabiola.ui.data.ArtistUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
 class DetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val networkRepository: NetworkRepository
) : ViewModel() {

   private val detailArg=DetailArg(savedStateHandle)

    private val _detailState = MutableStateFlow(DetailState().copy( artists = listOf(ArtistUiState(
        id = "Carlita",
        name = "Ernestina",
        image = "Tonja",
        type = "Shaquanda"
    )).toImmutableList()))
    val detailState= _detailState.asStateFlow()

}