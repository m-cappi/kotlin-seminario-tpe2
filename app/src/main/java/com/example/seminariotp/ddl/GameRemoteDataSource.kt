package com.example.seminariotp.ddl

import android.widget.Toast
import com.example.seminariotp.ddl.models.Game
import com.example.seminariotp.ddl.models.Genre
import com.example.seminariotp.ddl.models.Platform
import com.example.seminariotp.ddl.models.Publisher
import com.example.seminariotp.ddl.models.Store
import com.example.seminariotp.ui.games.GamesRoute
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRemoteDataSource @Inject constructor(
    private val gameApi: GameApi
) {
    //    suspend fun getGames(qty: Int): List<Game>? {
//        return withContext(Dispatchers.IO) {
//            try {
//                val response = gameApi.getGames(qty)
//                if (response.isSuccessful) {
//                    return@withContext response.body()?.results?.map { it.toDomain() }
//                }
//                return@withContext null
//            } catch (e: Exception) {
//                e.printStackTrace()
//                return@withContext null
//            }
//        }
//    }
    suspend fun getGames(qty: Int, route: GamesRoute?): List<Game>? {
        return withContext(Dispatchers.IO) {
            try {
                val response = if (route == null) {
                    gameApi.getGames(qty)
                } else {
                    val orderBy =
                        if (route.isReverseOrder) "-${route.selectedOrderBy}" else route.selectedOrderBy
                    val filters = route.categoryFilters?.joinToString(",")

                    when (route.selectedCategory) {
                        "Genres" -> gameApi.getGames(qty, orderBy, genres = filters)
                        "Platforms" -> gameApi.getGames(qty, orderBy, platforms = filters)
                        "Publishers" -> gameApi.getGames(qty, orderBy, publishers = filters)
                        "Stores" -> gameApi.getGames(qty, orderBy, stores = filters)
                        else -> gameApi.getGames(qty, orderBy)
                    }
                }

                if (response.isSuccessful) {
                    response.body()?.results?.map { it.toDomain() }
                } else null
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }

    suspend fun getGenres(qty: Int): List<Genre>? {
        return withContext(Dispatchers.IO) {
            try {
                val response = gameApi.getGenres(qty)
                if (response.isSuccessful) {
                    return@withContext response.body()?.results?.map { it.toDomain() }
                }
                return@withContext null
            } catch (e: Exception) {
                e.printStackTrace()
                return@withContext null
            }
        }
    }

    suspend fun getPlatforms(qty: Int): List<Platform>? {
        return withContext(Dispatchers.IO) {
            try {
                val response = gameApi.getPlatforms(qty)
                if (response.isSuccessful) {
                    return@withContext response.body()?.results?.map { it.toDomain() }
                }
                return@withContext null
            } catch (e: Exception) {
                e.printStackTrace()
                return@withContext null
            }
        }
    }

    suspend fun getPublishers(qty: Int): List<Publisher>? {
        return withContext(Dispatchers.IO) {
            try {
                val response = gameApi.getPublishers(qty)
                if (response.isSuccessful) {
                    return@withContext response.body()?.results?.map { it.toDomain() }
                }
                return@withContext null
            } catch (e: Exception) {
                e.printStackTrace()
                return@withContext null
            }
        }
    }

    suspend fun getStores(qty: Int): List<Store>? {
        return withContext(Dispatchers.IO) {
            try {
                val response = gameApi.getStores(qty)
                if (response.isSuccessful) {
                    return@withContext response.body()?.results?.map { it.toDomain() }
                }
                return@withContext null
            } catch (e: Exception) {
                e.printStackTrace()
                return@withContext null
            }
        }
    }
}
