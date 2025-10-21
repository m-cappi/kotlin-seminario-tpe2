package com.example.seminariotp.ddl

import com.example.seminariotp.ddl.models.Game
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRemoteDataSource @Inject constructor(
    private val gameApi: GameApi
){
    suspend fun getGames(qty: Int): List<Game>?{
        return withContext(Dispatchers.IO){
            try {
                val response = gameApi.getGames(qty)
                if(response.isSuccessful){
                    return@withContext response.body()?.results?.map { it.toDomain() }
                }
                return@withContext null
            }catch (e: Exception){
                e.printStackTrace()
                return@withContext null
            }
        }
    }
}