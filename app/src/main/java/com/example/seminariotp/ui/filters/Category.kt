package com.example.seminariotp.ui.filters

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.seminariotp.R

enum class Category(val resId: Int) {
    Genres(R.string.category_genres),
    Platforms(R.string.category_platforms),
    Publishers(R.string.category_publishers),
    Stores(R.string.category_stores)
}

@Composable
fun Category.displayName(): String = stringResource(this.resId)
