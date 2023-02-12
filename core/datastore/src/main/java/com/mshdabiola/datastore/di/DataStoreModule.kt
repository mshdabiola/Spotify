package com.mshdabiola.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.mshdabiola.common.appdispatchers.AppDispatchers
import com.mshdabiola.common.appdispatchers.Dispatcher
import com.mshdabiola.datastore.IUserPreferenceDataSource
import com.mshdabiola.datastore.UserPreferenceDatasource
import com.mshdabiola.datastore.UserPreferenceSerializer
import com.mshdabiola.datastore.UserPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataStoreModule {

    @Provides
    @Singleton
    fun provideUserPreferenceDataStore(
        @ApplicationContext context: Context,
        @Dispatcher(AppDispatchers.IO) ioDispatcher: CoroutineDispatcher,
        userPreferenceSerializer: UserPreferenceSerializer,
    ): DataStore<UserPreferences> {
        return DataStoreFactory.create(
            serializer = userPreferenceSerializer,
            scope = CoroutineScope(ioDispatcher + SupervisorJob())
        ) {
            context.dataStoreFile("user_preference.pd")
        }
    }
}

@InstallIn(SingletonComponent::class)
@Module
interface DataModule2{

    @Binds
    @Singleton
    fun bindUserPreferencesDataSource(iUserPreferences: IUserPreferenceDataSource):UserPreferenceDatasource

}
