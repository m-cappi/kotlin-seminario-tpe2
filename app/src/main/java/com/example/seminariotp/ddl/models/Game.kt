package com.example.seminariotp.ddl.models

import com.example.seminariotp.ddl.dto.GameDto

data class Game(
    val id: Int,
    val name: String,
    val releaseDate: String,
    val imageUrl: String?,
    val rating: Double,
    val platforms: List<String>,
    val esrbRating: String?
){
//    companion object{
//        fun GameDto.toDomain(): Game {
//            return Game(
//                id = id ?: 0,
//                name = name.orEmpty(),
//                releaseDate = released.orEmpty(),
//                imageUrl = backgroundImage,
//                rating = rating ?: 0.0,
//                platforms = platforms?.mapNotNull { it.platform?.name } ?: emptyList(),
//                esrbRating = esrbRating?.name
//            )
//        }
//    }
}
