package com.example.seminariotp.ddl

import com.example.seminariotp.ddl.dto.ApiResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApi {
    @GET("/games")
    suspend fun getGames(
        @Query("page_size")
        qty: Int
    ): Response<ApiResponseDto>
}