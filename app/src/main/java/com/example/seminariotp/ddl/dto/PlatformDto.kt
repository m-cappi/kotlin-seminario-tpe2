package com.example.seminariotp.ddl.dto

import com.example.seminariotp.ddl.models.Platform
import com.google.gson.annotations.SerializedName

data class PlatformDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("games_count")
    val gamesCount: Int,
) {
    fun toDomain(): Platform {
        return Platform(
            id, name, slug, gamesCount
        )
    }
}