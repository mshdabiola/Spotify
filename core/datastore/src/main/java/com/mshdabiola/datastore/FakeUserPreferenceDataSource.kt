package com.mshdabiola.datastore

import com.mshdabiola.model.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeUserPreferenceDataSource : UserPreferenceDatasource {

    private var userPreferences = userPreferences { token = "abiola" }
    override val userData: Flow<UserData>
        get() = flow { UserData(token = "abiola") }

    override suspend fun setToken(token: String) {
        userPreferences = userPreferences.copy { this.token = token }
    }
}