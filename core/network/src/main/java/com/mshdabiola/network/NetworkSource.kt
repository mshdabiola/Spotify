package com.mshdabiola.network

import com.mshdabiola.network.model.FPlaylist
import com.mshdabiola.network.model.NewRelease
import com.mshdabiola.network.model.Playlists
import com.mshdabiola.network.model.Recommendation
import com.mshdabiola.network.model.component.Category
import com.mshdabiola.network.request.Request
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.plugins.resources.get
import timber.log.Timber
import javax.inject.Inject

class NetworkSource @Inject constructor(
    private val httpClient: HttpClient,
) {

    suspend fun getRecommendation(): Recommendation {
     return   httpClient.get(Request.Recommendations()).body()
    }

    suspend fun getCategory():Category{
      return  httpClient.get(Request.Browse.Category()).body()
    }

    suspend fun getPlaylist(id : String):Playlists{
       return httpClient
           .get(Request.Browse.Category.Id.Playlist(Request.Browse.Category.Id(id = id))).body()
    }

    suspend fun getFeaturePlaylist():FPlaylist{
      return  httpClient.get(Request.Browse.FeaturedPlaylist()).body()
    }

    suspend fun getNewRelease():NewRelease{
        return httpClient.get(Request.Browse.NewReleases()).body()

    }
}

fun Exception.toCustomExceptions() = when (this) {

    is ServerResponseException -> HttpErrorInternalServerError(this)
    is ClientRequestException ->
        when (this.response.status.value) {
            400 -> HttpErrorBadRequest(this)
            401 -> HttpErrorUnauthorized(this)
            403 -> HttpErrorForbidden(this)
            404 -> HttpErrorNotFound(this)
            else -> HttpError(this)
        }
    is RedirectResponseException -> HttpError(this)
    else -> GenericError(this)
}

class HttpErrorBadRequest(throwable: Throwable) : Exception(throwable)
class HttpError(throwable: Throwable) : Exception(throwable)
class HttpErrorUnauthorized(throwable: Throwable) : Exception(throwable)
class HttpErrorNotFound(throwable: Throwable) : Exception(throwable)
class HttpErrorForbidden(throwable: Throwable) : Exception(throwable)
class HttpErrorInternalServerError(throwable: Throwable) : Exception(throwable)
class GenericError(throwable: Throwable) : Exception(throwable)







