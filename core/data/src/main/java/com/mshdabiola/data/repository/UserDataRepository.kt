package com.mshdabiola.data.repository

import com.mshdabiola.model.UserData
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {

    val data:Flow<UserData>
    suspend fun setToken(token: String)

}
