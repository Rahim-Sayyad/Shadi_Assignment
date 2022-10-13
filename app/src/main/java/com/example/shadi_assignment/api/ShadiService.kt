package com.example.shadi_assignment.api

import com.example.shadi_assignment.models.modelsNew
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ShadiService {

    @GET("api/")
    suspend fun getResult(@Query("results") page: Int) : Response<modelsNew>

}