package com.example.seminariotp.ui.games

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.seminariotp.GameViewModel

@Composable
fun GamesScreen(
    viewModel: GameViewModel,
    gamesRoute: GamesRoute,
    goFilters: () -> Unit
) {
    val isLoading by viewModel.loading.collectAsStateWithLifecycle()
    val games by viewModel.games.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getGames(50)
    }

    GamesContent(
        isLoading = isLoading,
        games = games.orEmpty(),
        onRefreshGames = {
            viewModel.getGames(50)
        },
        onFiltersClick = goFilters,
    )
}