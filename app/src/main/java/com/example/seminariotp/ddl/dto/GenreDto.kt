package com.example.seminariotp.ddl.dto

import com.example.seminariotp.ddl.models.Genre
import com.google.gson.annotations.SerializedName

data class GenreDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("games_count")
    val gamesCount: Int? = null,
) {
    fun toDomain(): Genre {
        return Genre(
            id, name, slug, gamesCount
        )
    }
}