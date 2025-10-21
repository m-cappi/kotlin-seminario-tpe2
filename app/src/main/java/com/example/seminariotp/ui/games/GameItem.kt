package com.example.seminariotp.ui.games

import com.example.seminariotp.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

    Row (
        modifier=modifier,
    ){
        AsyncImage(
            modifier = Modifier.size(80.dp),
            model = imageUrl.orEmpty(),
            contentDescription = null,
            placeholder = painterResource(R.drawable.placeholder_image),
            error = painterResource(R.drawable.broken_image)
        )

        Column {
            Text(
                text = name
            )
            Row {
                Text(
                    text = releaseDate
                )
                Text(
                    text = rating.toString()
                )
            }
        }
    }
}

@Preview
@Composable
private fun GameItemPreview(){
    GameItem(
        name = "Cyberpunk2077",
        releaseDate= "Unspecified year",
        imageUrl= "not_found",
        rating= 7.5,
    )
}