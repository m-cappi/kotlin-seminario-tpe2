package com.example.seminariotp.ddl

import com.example.seminariotp.ddl.models.Game
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepository @Inject constructor(
    private val gameRemoteDataSource: GameRemoteDataSource
){
    suspend fun getGames(qty: Int): List<Game>?{
        return gameRemoteDataSource.getGames(qty)
    }
}