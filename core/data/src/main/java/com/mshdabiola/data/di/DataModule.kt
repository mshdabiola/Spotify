package com.mshdabiola.data.di

import com.mshdabiola.data.repository.INetworkRepository
import com.mshdabiola.data.repository.NetworkRepository
import com.mshdabiola.data.repository.RealUserDataRepository
import com.mshdabiola.data.repository.UserDataRepository
import com.mshdabiola.data.util.ConnectivityManagerNetworkMonitor
import com.mshdabiola.data.util.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface DataModule {

    @Binds
    fun bindNetworkRepository(iNetworkRepository: INetworkRepository): NetworkRepository

    @Binds
    fun bindUserDataRepository(realUserDataRepository: RealUserDataRepository): UserDataRepository

    @Binds
    fun bindNetworkMonitor(connectivityManagerNetworkMonitor: ConnectivityManagerNetworkMonitor): NetworkMonitor
}
