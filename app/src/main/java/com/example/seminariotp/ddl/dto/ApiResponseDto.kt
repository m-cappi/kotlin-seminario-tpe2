package com.example.seminariotp.ddl.dto

import com.google.gson.annotations.SerializedName

data class ApiResponseDto<T>(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("previous")
    val previous: String? = null,
    @SerializedName("results")
    val results: List<T>? = null
)


/*
# SHORTENED SAMPLE RESPONSE
{
  "count": 894779,
  "next": "https://api.rawg.io/api/games?key=9e0d7f72934d4e26908a71c50bd29e33&page=2&page_size=1",
  "previous": null,
  "results": [
    {
      "id": 3498,
      "slug": "grand-theft-auto-v",
      "name": "Grand Theft Auto V",
      "released": "2013-09-17",
      "tba": false,
      "background_image": "https://media.rawg.io/media/games/20a/20aa03a10cda45239fe22d035c0ebe64.jpg",
      "rating": 4.47,
      "rating_top": 5,
      "ratings": [
        {
          "id": 5,
          "title": "exceptional",
          "count": 4341,
          "percent": 59.09
        },
        {
          "id": 4,
          "title": "recommended",
          "count": 2397,
          "percent": 32.63
        },
        {
          "id": 3,
          "title": "meh",
          "count": 467,
          "percent": 6.36
        },
        {
          "id": 1,
          "title": "skip",
          "count": 142,
          "percent": 1.93
        }
      ],
      "ratings_count": 7231,
      "reviews_text_count": 67,
      "added": 22276,
      "metacritic": 92,
      "playtime": 74,
      "suggestions_count": 443,
      "updated": "2025-10-20T09:59:31",
      "user_game": null,
      "reviews_count": 7347,
      "saturated_color": "0f0f0f",
      "dominant_color": "0f0f0f",
      "genres": [
        {
          "id": 4,
          "name": "Action",
          "slug": "action",
          "games_count": 190172,
          "image_background": "https://media.rawg.io/media/games/511/5118aff5091cb3efec399c808f8c598f.jpg"
        }
      ],
      "clip": null,
      "short_screenshots": [
        {
          "id": -1,
          "image": "https://media.rawg.io/media/games/20a/20aa03a10cda45239fe22d035c0ebe64.jpg"
        },
        {
          "id": 1827221,
          "image": "https://media.rawg.io/media/screenshots/a7c/a7c43871a54bed6573a6a429451564ef.jpg"
        },
        {
          "id": 1827222,
          "image": "https://media.rawg.io/media/screenshots/cf4/cf4367daf6a1e33684bf19adb02d16d6.jpg"
        },
        {
          "id": 1827223,
          "image": "https://media.rawg.io/media/screenshots/f95/f9518b1d99210c0cae21fc09e95b4e31.jpg"
        },
        {
          "id": 1827225,
          "image": "https://media.rawg.io/media/screenshots/a5c/a5c95ea539c87d5f538763e16e18fb99.jpg"
        },
        {
          "id": 1827226,
          "image": "https://media.rawg.io/media/screenshots/a7e/a7e990bc574f4d34e03b5926361d1ee7.jpg"
        },
        {
          "id": 1827227,
          "image": "https://media.rawg.io/media/screenshots/592/592e2501d8734b802b2a34fee2df59fa.jpg"
        }
      ]
    }
  ]
}
 */





