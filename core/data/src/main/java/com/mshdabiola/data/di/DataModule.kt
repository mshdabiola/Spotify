package com.mshdabiola.data.di

import com.mshdabiola.data.repository.INetworkRepository
import com.mshdabiola.data.repository.ModelRepository
import com.mshdabiola.data.repository.NetworkRepository
import com.mshdabiola.data.repository.RealModelRepository
import com.mshdabiola.data.repository.RealUserDataRepository
import com.mshdabiola.data.repository.UserDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface DataModule {

    @Binds
    fun bindModelRepository(realModelRepository: RealModelRepository): ModelRepository

    @Binds
    fun bindNetworkRepository(iNetworkRepository: INetworkRepository): NetworkRepository

    @Binds
    fun bindUserDataRepository(realUserDataRepository: RealUserDataRepository): UserDataRepository
}
