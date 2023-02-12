package com.mshdabiola.datastore

import androidx.datastore.core.DataStore
import com.mshdabiola.model.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class IUserPreferenceDataSource @Inject constructor(
    private val userPreferences: DataStore<UserPreferences>,
) :UserPreferenceDatasource{
    override val userData = userPreferences.data
        .map {
            UserData(token = it.token)
        }

    override suspend fun setToken(token: String) {
        userPreferences.updateData {
            it.copy {
                this.token=token
            }
        }
    }


}
