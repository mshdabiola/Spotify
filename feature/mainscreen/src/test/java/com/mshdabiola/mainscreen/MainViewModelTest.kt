package com.mshdabiola.mainscreen

import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import com.mshdabiola.data.repository.ModelRepository
import com.mshdabiola.model.Model
import com.mshdabiola.testing.MainDispatcherRule
import com.mshdabiola.testing.repository.FakeNetworkRepository
import com.mshdabiola.testing.repository.TestModelRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    lateinit var modelRepository: ModelRepository
    lateinit var mainViewModel: MainViewModel

    @Before
    fun setUp() {
        modelRepository = TestModelRepository()

        mainViewModel = MainViewModel(
            networkRepository = FakeNetworkRepository()
        )
    }

    @Test
    fun getMainState() {
    }
    @Test
    fun getPlaylist()= runTest{
        mainViewModel
            .mainState
            .test {
                assertEquals("1",awaitItem().featurePlaylist.first().id)
            }
    }

    @Test
    fun getRelatedArtists()= runTest(){
        mainViewModel
            .mainState
            .test {
                assertEquals(20,awaitItem().relatedArtiste.size)
            }
    }
}
