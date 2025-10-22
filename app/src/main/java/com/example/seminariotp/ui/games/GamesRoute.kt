package com.example.seminariotp.ui.games

import kotlinx.serialization.Serializable

@Serializable
class GamesRoute(
    val selectedCategory: String? = null,
    val categoryFilters: List<String>? = null,
    val selectedOrderBy: String? = null,
    val isReverseOrder: Boolean = false
)
