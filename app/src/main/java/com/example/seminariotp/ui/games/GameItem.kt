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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun GameItem(
    modifier: Modifier = Modifier,
    name: String,
    releaseDate: String,
    imageUrl: String?,
    rating: Double,
) {

    Row(
        modifier = modifier,
    ) {
        AsyncImage(
            modifier = Modifier.size(80.dp),
            model = imageUrl.orEmpty(),
            contentDescription = null,
            placeholder = painterResource(R.drawable.placeholder_image),
            error = painterResource(R.drawable.broken_image)
        )

        Column(
            modifier = Modifier.fillMaxWidth().height(80.dp).padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge,
            )
//            Spacer(Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxSize().padding(4.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                ) {
                Text(
                    text = "Rating: $rating"
                )
                Text(
                    text = "Released: $releaseDate"
                )
//                Spacer(Modifier.width(20.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GameItemPreview() {
    GameItem(
        name = "Cyberpunk2077",
        releaseDate = "Unspecified year",
        imageUrl = "not_found",
        rating = 7.5,
    )
}