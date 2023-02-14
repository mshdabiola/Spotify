package com.mshdabiola.datastore

import com.mshdabiola.model.UserData
import kotlinx.coroutines.flow.Flow

interface UserPreferenceDatasource {

    val userData: Flow<UserData>
    suspend fun setToken(token: String)

}