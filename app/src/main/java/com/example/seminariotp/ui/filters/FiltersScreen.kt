package com.example.seminariotp.ui.filters

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
    val isError by viewModel.error.collectAsStateWithLifecycle()
    val genres by viewModel.genres.collectAsStateWithLifecycle()
    val platforms by viewModel.platforms.collectAsStateWithLifecycle()
    val publishers by viewModel.publishers.collectAsStateWithLifecycle()
    val stores by viewModel.stores.collectAsStateWithLifecycle()
    val filtersMap = mapOf(
        Category.Genres to genres,
        Category.Platforms to platforms,
        Category.Publishers to publishers,
        Category.Stores to stores,
    )
    val categories = Category.entries.map { it }
    var selectedCategory by remember { mutableStateOf(categories.first()) }
    var selectedFilters by remember { mutableStateOf(listOf<String>()) }

    val orderByOptions = OrderBy.entries.map { it.displayName() }
    var selectedOrderBy by remember { mutableStateOf("") }
    var isReverseOrder by remember { mutableStateOf(false) }
    var retryTrigger by remember { mutableIntStateOf(0) }

    LaunchedEffect(selectedCategory, retryTrigger) {
        when (selectedCategory) {
            Category.Genres -> viewModel.getGenres(20)
            Category.Platforms -> viewModel.getPlatforms(20)
            Category.Publishers -> viewModel.getPublishers(20)
            Category.Stores -> viewModel.getStores(20)
        }
    }

    val onApplyFilters = {
        val selectedCategory = if (selectedFilters.isEmpty()) "" else selectedCategory.toString()
        val route = GamesRoute(
            selectedCategory = selectedCategory,
            categoryFilters = selectedFilters,
            selectedOrderBy = selectedOrderBy,
            isReverseOrder = isReverseOrder
        )
        goGames(route)
    }

    FiltersContent(
        isLoading = isLoading,
        isError = isError,
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
        onApplyFilters = onApplyFilters,
        onRetry = { retryTrigger++ }
    )
}
