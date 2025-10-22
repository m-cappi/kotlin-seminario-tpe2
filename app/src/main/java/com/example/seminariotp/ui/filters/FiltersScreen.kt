package com.example.seminariotp.ui.filters

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.seminariotp.FiltersViewModel
import com.example.seminariotp.ui.games.GamesRoute

@Composable
fun FiltersScreen(
    viewModel: FiltersViewModel,
    goGames: (GamesRoute) -> Unit
) {
    val isLoading by viewModel.loading.collectAsStateWithLifecycle()
    val genres by viewModel.genres.collectAsStateWithLifecycle()
    val platforms by viewModel.platforms.collectAsStateWithLifecycle()
    val publishers by viewModel.publishers.collectAsStateWithLifecycle()
    val stores by viewModel.stores.collectAsStateWithLifecycle()
    val filtersMap = mapOf(
        "Genres" to genres,
        "Platforms" to platforms,
        "Publishers" to publishers,
        "Stores" to stores,
    )
    val categories = listOf("Genres", "Platforms", "Publishers", "Stores")
    var selectedCategory by remember { mutableStateOf(categories.first()) }
    var selectedFilters by remember { mutableStateOf(listOf<String>()) }

    val orderByOptions =
        listOf("name", "released", "added", "created", "updated", "rating", "metacritic")
    var selectedOrderBy by remember { mutableStateOf("") }
    var isReverseOrder by remember { mutableStateOf(false) }

    LaunchedEffect(selectedCategory) {
        when (selectedCategory) {
            "Genres" -> viewModel.getGenres(20)
            "Platforms" -> viewModel.getPlatforms(20)
            "Publishers" -> viewModel.getPublishers(20)
            "Stores" -> viewModel.getStores(20)
        }
    }

    val onApplyFilters = {
        // Create a GamesRoute object instead of building a string
        val route = GamesRoute(
            selectedCategory = selectedCategory,
            categoryFilters = selectedFilters,
            selectedOrderBy = selectedOrderBy,
            isReverseOrder = isReverseOrder
        )

        // Call the lambda to navigate
        goGames(route)
    }

    FiltersContent(
        isLoading = isLoading,
        filtersMap = filtersMap,
        categories = categories,
        selectedCategory = selectedCategory,
        selectedFilters = selectedFilters,
        onCategorySelected = {
            selectedCategory = it
            selectedFilters = listOf() // reset selection on category change
        },
        onSelectionChanged = { selectedFilters = it },
        orderByOptions = orderByOptions,
        selectedOrderBy = selectedOrderBy,
        isReverseOrder = isReverseOrder,
        onOrderChange = { newOrder, newReverse ->
            selectedOrderBy = newOrder
            isReverseOrder = newReverse
        },
        onApplyFilters = onApplyFilters
    )
}
