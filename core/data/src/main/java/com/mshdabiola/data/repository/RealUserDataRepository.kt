package com.mshdabiola.data.repository

import com.mshdabiola.datastore.UserPreferenceDatasource
import com.mshdabiola.model.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RealUserDataRepository @Inject constructor(
    private val userPreference: UserPreferenceDatasource,
) : UserDataRepository {

    override val data: Flow<UserData>
        get() = userPreference.userData


    override suspend fun setToken(token: String) {
        userPreference.setToken(token)
    }


}
