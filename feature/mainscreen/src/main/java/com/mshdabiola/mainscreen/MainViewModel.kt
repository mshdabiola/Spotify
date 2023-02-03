package com.mshdabiola.mainscreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mshdabiola.data.repository.ModelRepository
import com.mshdabiola.data.repository.NetworkRepository
import com.mshdabiola.ui.toTrackUiState
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
    private val savedStateHandle: SavedStateHandle,
    private val modelRepository: ModelRepository,
    private val networkRepository: NetworkRepository
) : ViewModel() {

    private val _mainState= MutableStateFlow(MainState())
    val mainState=_mainState.asStateFlow()
    init {
        viewModelScope.launch {

            networkRepository
                .newRelease()
               .onSuccess { albumList ->
                   val value=  albumList.map { it.toTrackUiState() }
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
                .recommendation()
                .onSuccess { albumList ->
                    val value=  albumList.map { it.toTrackUiState() }
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
    }

}
