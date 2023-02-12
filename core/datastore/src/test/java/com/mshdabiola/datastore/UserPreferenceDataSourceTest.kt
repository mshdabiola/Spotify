package com.mshdabiola.datastore

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

@OptIn(ExperimentalCoroutinesApi::class)
class UserPreferenceDataSourceTest {

    private lateinit var userPreferenceDataSource: IUserPreferenceDataSource

    @get:Rule
    val temporaryFolder: TemporaryFolder = TemporaryFolder.builder().assureDeletion().build()

    @Before
    fun setUp() {
        userPreferenceDataSource = IUserPreferenceDataSource(
            temporaryFolder.testUserPreferenceDataStore(),
        )
    }

    @Test
    fun setToken() = runTest {
        userPreferenceDataSource.setToken("abiola")
        assertEquals(userPreferenceDataSource.userData.first().token, "abiola")
    }

}
