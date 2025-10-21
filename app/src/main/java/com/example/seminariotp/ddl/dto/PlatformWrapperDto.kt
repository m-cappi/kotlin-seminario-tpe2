package com.example.seminariotp.ddl.dto

import com.google.gson.annotations.SerializedName

data class PlatformWrapperDto(
    @SerializedName("platform")
    val platform: PlatformDto? = null,
    @SerializedName("released_at")
    val releasedAt: String? = null,
    @SerializedName("requirements")
    val requirements: RequirementsDto? = null
)