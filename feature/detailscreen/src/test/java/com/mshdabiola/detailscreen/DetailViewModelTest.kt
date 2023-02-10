package com.mshdabiola.detailscreen

import androidx.lifecycle.SavedStateHandle
import com.mshdabiola.testing.MainDispatcherRule
import com.mshdabiola.testing.repository.FakeNetworkRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class DetailViewModelTest{

    @get:Rule
    val mainDispatcherRule=MainDispatcherRule()
    private lateinit var detailViewModel: DetailViewModel
    @Before
    fun set(){
        val savedStateHandle=SavedStateHandle(mapOf(detail_id to "1234", detail_type to "track"))

        detailViewModel= DetailViewModel(savedStateHandle,FakeNetworkRepository())
    }

    @Test
    fun checkNavArgument(){
        assertEquals("1234",detailViewModel.detailArg.id)
        assertEquals("track",detailViewModel.detailArg.type)
    }
}