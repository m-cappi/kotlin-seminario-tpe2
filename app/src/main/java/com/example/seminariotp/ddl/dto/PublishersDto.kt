package com.example.seminariotp.ddl.dto

import com.example.seminariotp.ddl.models.Publisher
import com.google.gson.annotations.SerializedName

data class PublisherDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("games_count")
    val gamesCount: Int,
) {
    fun toDomain(): Publisher {
        return Publisher(id, name, slug, gamesCount)
    }
}