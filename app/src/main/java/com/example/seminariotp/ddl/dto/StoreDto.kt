package com.example.seminariotp.ddl.dto

import com.example.seminariotp.ddl.models.Store
import com.google.gson.annotations.SerializedName


data class StoreDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("domain")
    val domain: String? = null,
    @SerializedName("games_count")
    val gamesCount: Int? = null,
) {
    fun toDomain(): Store {
        return Store(id, name, slug, domain, gamesCount)
    }
}