package com.example.seminariotp.ddl.dto

import com.example.seminariotp.ddl.models.Genre
import com.google.gson.annotations.SerializedName

data class GenreDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("games_count")
    val gamesCount: Int,
) {
    fun toDomain(): Genre {
        return Genre(
            id, name, slug, gamesCount
        )
    }
}