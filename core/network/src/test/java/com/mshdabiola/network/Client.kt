package com.mshdabiola.network

import com.mshdabiola.network.di.code
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.UserAgent
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.cache.storage.FileStorage
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.plugins.resources.Resources
import io.ktor.client.request.headers
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import java.io.File

object Client {
    fun get(httpClientEngine: HttpClientEngine) = HttpClient(httpClientEngine) {
        defaultRequest {

            headers {
                this[HttpHeaders.Authorization] = "Bearer $code"
                this[HttpHeaders.Accept] = "application/json"
                this[HttpHeaders.ContentType] = "application/json"
            }
            url {
                host = "api.spotify.com"
                protocol = URLProtocol.HTTPS
            }
        }
        install(Resources)

        install(Logging) {
            logger = io.ktor.client.plugins.logging.Logger.SIMPLE
            level = LogLevel.ALL

        }


        install(ContentNegotiation) {
            json(Json {
                this.ignoreUnknownKeys = true
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
