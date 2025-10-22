package com.example.seminariotp.ui.games

import android.os.Parcelable
import kotlinx.serialization.Serializable
import kotlinx.parcelize.Parcelize

@Parcelize
class GamesRoute(
    val selectedCategory: String? = null,
    val categoryFilters: List<String>? = null,
    val selectedOrderBy: String? = null,
    val isReverseOrder: Boolean = false
) : Parcelable
