package com.example.seminariotp.ui.games


import androidx.compose.foundation.layout.Arrangement
import com.example.seminariotp.R

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seminariotp.ddl.models.Game


@Composable
fun GamesContent(
    isLoading: Boolean,
    isError: Boolean,
    games: List<Game>,
    onRefreshGames: () -> Unit,
    onFiltersClick: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = onRefreshGames, enabled = !isLoading) {
                Text(
                    text = stringResource(R.string.refresh_games)
                )
            }
            IconButton(onClick = onFiltersClick) {
                Icon(
                    painter = painterResource(R.drawable.filters_list),
                    contentDescription = null,
                )
            }
        }

        if (isLoading) {
            CircularProgressIndicator()
        } else if (isError) {
            Text(
                text = stringResource(R.string.error_msg)
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                items(games) { game ->
                    GameItem(
                        modifier = Modifier.padding(vertical = 6.dp),
                        name = game.name,
                        imageUrl = game.imageUrl,
                        rating = game.rating,
                        releaseDate = game.releaseDate,
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewGamesContent() {
    GamesContent(
        isLoading = false,
        isError = false,
        games = listOf(
            Game(
                id = 0,
                name = "Best game",
                releaseDate = "sometime ago",
                imageUrl = "not found",
                rating = 7.7,
                platforms = listOf("pc"),
            ),
            Game(
                id = 0,
                name = "Best game",
                releaseDate = "sometime ago",
                imageUrl = "not found",
                rating = 7.7,
                platforms = listOf("pc"),
            ),
            Game(
                id = 0,
                name = "Best game",
                releaseDate = "sometime ago",
                imageUrl = "not found",
                rating = 7.7,
                platforms = listOf("pc"),
            ),
        ),
        onRefreshGames = {},
        onFiltersClick = {},
    )
}