package com.example.seminariotp.ui.filters

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.seminariotp.R

enum class OrderBy(val resId: Int) {
    Name(R.string.order_name),
    Released(R.string.order_released),
    Added(R.string.order_added),
    Created(R.string.order_created),
    Updated(R.string.order_updated),
    Rating(R.string.order_rating),
    Metacritic(R.string.order_metacritic)
}

@Composable
fun OrderBy.displayName(): String = stringResource(this.resId)
