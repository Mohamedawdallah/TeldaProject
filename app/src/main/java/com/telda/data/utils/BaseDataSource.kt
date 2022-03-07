package com.telda.data.utils

import retrofit2.Response
import java.net.UnknownHostException


abstract class BaseDataSource {

    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Resource<T> {

        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    return Resource.Success(body, "")
                }
            }
            return Resource.Failed("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return Resource.Failed(e.message ?: e.toString())
        } catch (e: UnknownHostException) {
            return Resource.NoConnection()
        }
    }

}