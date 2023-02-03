package com.mshdabiola.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.HttpSend
import io.ktor.client.plugins.UserAgent
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.cache.storage.FileStorage
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.plugins.resources.Resources
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.header
import io.ktor.client.request.headers
import io.ktor.http.HttpHeaders
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol
import io.ktor.http.Url
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import java.io.File
import java.net.URL
import java.util.logging.Logger

const val code="BQAUFlGO4esOAm9p2B03cvsOl9afk2UwoaIkJVAL21SYukbxiIDvYnJhcQAVN8c-GgIzMel12hu3XSVu9BKh1YA8oLwkwWdEpjwMh7yxrV1RbVsB0L1Zm2VBuHqZbJ4E-4YgaiI_PmKc2CF16A8DHUQ7ypM32LNYWUDP8bDctSmC2S144dtHRuFU1Kucm6DPHCEk"
@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    fun clientProvider() = HttpClient(Android) {
        defaultRequest {

            headers {
                this[HttpHeaders.Authorization]="Bearer $code"
                this[HttpHeaders.Accept]="application/json"
                this[HttpHeaders.ContentType]="application/json"
            }
            url {
                host="api.spotify.com"
                protocol= URLProtocol.HTTPS
            }
        }
        install(Resources)

        install(Logging) {
            logger = io.ktor.client.plugins.logging.Logger.SIMPLE
            level = LogLevel.ALL

        }


        install(ContentNegotiation) {
            json(Json {
                this.ignoreUnknownKeys=true
            })
        }

        install(UserAgent) {
            agent = "ktor client"

        }
//        install(HttpRequestRetry) {
//            retryOnServerErrors(5)
//            exponentialDelay()
//        }
        install(HttpCache) {
            val file = File.createTempFile("abiola", "tem")
            publicStorage(FileStorage(file))
        }

    }
}
