package com.example.seminariotp.ddl.dto

import com.google.gson.annotations.SerializedName

data class RequirementsDto(
    @SerializedName("minimum")
    val minimum: String? = null,
    @SerializedName("recommended")
    val recommended: String? = null
)