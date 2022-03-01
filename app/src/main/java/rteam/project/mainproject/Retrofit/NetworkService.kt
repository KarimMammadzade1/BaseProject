package rteam.project.mainproject.Retrofit

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface NetworkService {

    @GET("kotlin")
    fun getRequest(
        @Header("url") url: String
    )
}