package com.example.seminariotp.ddl

import com.example.seminariotp.ddl.dto.ApiResponseDto
import com.example.seminariotp.ddl.dto.GameDto
import com.example.seminariotp.ddl.dto.GenreDto
import com.example.seminariotp.ddl.dto.PlatformDto
import com.example.seminariotp.ddl.dto.PublisherDto
import com.example.seminariotp.ddl.dto.StoreDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApi {
//    @GET("/api/games")
//    suspend fun getGames(
//        @Query("page_size")
//        qty: Int
//    ): Response<ApiResponseDto<GameDto>>

    @GET("/api/games")
    suspend fun getGames(
        @Query("page_size") qty: Int,
        @Query("ordering") orderBy: String? = null,
        @Query("genres") genres: String? = null,
        @Query("platforms") platforms: String? = null,
        @Query("publishers") publishers: String? = null,
        @Query("stores") stores: String? = null
    ): Response<ApiResponseDto<GameDto>>

    @GET("/api/genres")
    suspend fun getGenres(
        @Query("page_size")
        qty: Int
    ): Response<ApiResponseDto<GenreDto>>

    @GET("/api/platforms")
    suspend fun getPlatforms(
        @Query("page_size")
        qty: Int
    ): Response<ApiResponseDto<PlatformDto>>

    @GET("/api/publishers")
    suspend fun getPublishers(
        @Query("page_size")
        qty: Int
    ): Response<ApiResponseDto<PublisherDto>>

    @GET("/api/stores")
    suspend fun getStores(
        @Query("page_size")
        qty: Int
    ): Response<ApiResponseDto<StoreDto>>

}