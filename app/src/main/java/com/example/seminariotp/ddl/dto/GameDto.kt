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
    @SerializedName("tba")
    val tba: Boolean? = null,
    @SerializedName("background_image")
    val backgroundImage: String? = null,
    @SerializedName("rating")
    val rating: Double? = null,
    @SerializedName("rating_top")
    val ratingTop: Int? = null,
    @SerializedName("ratings")
    val ratings: Map<String, Any>? = null,
    @SerializedName("ratings_count")
    val ratingsCount: Int? = null,
    @SerializedName("reviews_text_count")
    val reviewsTextCount: String? = null,
    @SerializedName("added")
    val added: Int? = null,
    @SerializedName("added_by_status")
    val addedByStatus: Map<String, Any>? = null,
    @SerializedName("metacritic")
    val metacritic: Int? = null,
    @SerializedName("playtime")
    val playtime: Int? = null,
    @SerializedName("suggestions_count")
    val suggestionsCount: Int? = null,
    @SerializedName("updated")
    val updated: String? = null,
    @SerializedName("esrb_rating")
    val esrbRating: EsrbRatingDto? = null,
    @SerializedName("platforms")
    val platforms: List<PlatformWrapperDto>? = null
){
    fun toDomain(): Game {
        return Game(
            id = id ?: 0,
            name = name.orEmpty(),
            releaseDate = released.orEmpty(),
            imageUrl = backgroundImage,
            rating = rating ?: 0.0,
            platforms = platforms?.mapNotNull { it.platform?.name } ?: emptyList(),
            esrbRating = esrbRating?.name
        )
    }
}