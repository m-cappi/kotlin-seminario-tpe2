package com.example.seminariotp.ddl.dto

import com.example.seminariotp.ddl.models.Game
import com.google.gson.annotations.SerializedName


data class GameDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("released")
    val released: String? = null,
    @SerializedName("background_image")
    val backgroundImage: String? = null,
    @SerializedName("rating")
    val rating: Double? = null,
    @SerializedName("rating_top")
    val ratingTop: Int? = null,
    @SerializedName("metacritic")
    val metacritic: Int? = null,
    @SerializedName("platforms")
    val platforms: List<PlatformWrapperDto>? = null
) {
    fun toDomain(): Game {
        return Game(
            id = id ?: 0,
            name = name.orEmpty(),
            releaseDate = released.orEmpty(),
            imageUrl = backgroundImage,
            rating = rating ?: 0.0,
            platforms = platforms?.mapNotNull { it.platform?.name } ?: emptyList(),
        )
    }
}