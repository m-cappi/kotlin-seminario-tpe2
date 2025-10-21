package com.example.seminariotp.ddl.dto

import com.google.gson.annotations.SerializedName

data class PlatformDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("name")
    val name: String? = null
)