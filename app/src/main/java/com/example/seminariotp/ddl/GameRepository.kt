package com.example.seminariotp.ddl

import com.example.seminariotp.ddl.models.Game
import com.example.seminariotp.ddl.models.Genre
import com.example.seminariotp.ddl.models.Platform
import com.example.seminariotp.ddl.models.Publisher
import com.example.seminariotp.ddl.models.Store
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepository @Inject constructor(
    private val gameRemoteDataSource: GameRemoteDataSource
) {
    suspend fun getGames(qty: Int): List<Game>? {
        return gameRemoteDataSource.getGames(qty)
    }

    suspend fun getGenres(qty: Int): List<Genre>? {
        return gameRemoteDataSource.getGenres(qty)
    }

    suspend fun getPlatforms(qty: Int): List<Platform>? {
        return gameRemoteDataSource.getPlatforms(qty)
    }

    suspend fun getPublishers(qty: Int): List<Publisher>? {
        return gameRemoteDataSource.getPublishers(qty)
    }

    suspend fun getStores(qty: Int): List<Store>? {
        return gameRemoteDataSource.getStores(qty)
    }
}