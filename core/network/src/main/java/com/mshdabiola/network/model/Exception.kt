package com.mshdabiola.network.model

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException


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
