package com.galaxy.evangelioninfoapp.evangelioninfo.data.mapper

import com.galaxy.evangelioninfoapp.evangelioninfo.domain.model.ApiError
import com.galaxy.evangelioninfoapp.evangelioninfo.domain.model.NetworkError
import retrofit2.HttpException
import java.io.IOException

fun Throwable.toNetworkError(): NetworkError {
    val error = when(this){
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }
    return NetworkError(error = error, t = this)
}