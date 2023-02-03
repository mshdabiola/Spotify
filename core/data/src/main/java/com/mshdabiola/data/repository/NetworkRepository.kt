package com.mshdabiola.data.repository

import com.mshdabiola.model.Album

interface NetworkRepository {
    suspend fun get()
    suspend fun recommendation(): Result<List<Album>>

    suspend fun newRelease(): Result<List<Album>>
}
