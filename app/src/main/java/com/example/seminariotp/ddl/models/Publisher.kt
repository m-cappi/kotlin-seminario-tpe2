package com.example.seminariotp.ddl.models

data class Publisher(
    val id: Int? = null,
    val name: String? = null,
    val slug: String? = null,
    val gamesCount: Int? = null,
) {
    fun toDomain(): Publisher {
        return Publisher(id, name, slug, gamesCount)
    }
}
