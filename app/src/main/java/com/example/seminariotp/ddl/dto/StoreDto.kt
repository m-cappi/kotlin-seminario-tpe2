package com.example.seminariotp.ddl.dto

import com.example.seminariotp.ddl.models.Store
import com.google.gson.annotations.SerializedName


data class StoreDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("games_count")
    val gamesCount: Int,
    @SerializedName("domain")
    val domain: String? = null,
) {
    fun toDomain(): Store {
        return Store(id, name, slug, gamesCount, domain)
    }
}