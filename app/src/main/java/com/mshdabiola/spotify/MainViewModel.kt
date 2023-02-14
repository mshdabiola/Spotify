package com.mshdabiola.spotify

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaMetadata
import com.mshdabiola.spotify.ui.toMediaItem
import com.mshdabiola.ui.data.TrackUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val player : MPlayer
) : ViewModel() {
   private val _mediaData = MutableStateFlow(MediaData())
    val mediaData =_mediaData.asStateFlow()
    var job : Job?=null
    init {
        viewModelScope.launch {
            player.listener= object : MPlayer.Listener{
                override fun onIsPlayingChanged(isPlay: Boolean) {
                   _mediaData.update {
                       it.copy(isPlaying=isPlay)
                   }
                }

                override fun onMetadataChanged(metadata: MediaMetadata) {
                    _mediaData.update {
                        it.copy(
                            image = metadata.artworkUri,
                            artists = metadata.artist?.toString(),
                            title = metadata.title?.toString(),
                            showPlayer = true
                            )
                    }
                }
            }
        }

        viewModelScope.launch {
            mediaData
                .map { it.isPlaying }
                .distinctUntilChanged()
                .collectLatest { isPlaying ->
                    if (isPlaying){
                       job= launch {
                            player.getProgress()?.collectLatest {p->
                                _mediaData.update {
                                    it.copy(progress = p)
                                }
                            }
                        }

                    }else{
                       job?.let { job1 ->
                           job1.cancel()
                           job=null
//                           _mediaData.update {
//                               it.copy(progress = 1f)
//                           }

                       }

                    }
                }
        }
    }


    fun setMediaItems(tracks:List<TrackUiState>){
        player.setMediaItem(tracks.map { it.toMediaItem() })
        player.play()
    }

    fun onPlay(){
        if (mediaData.value.isPlaying){
            player.pause()
        }else{
            player.play()
        }
    }

    override fun onCleared() {
        super.onCleared()
        player.onClear()
    }
}