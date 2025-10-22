package com.example.seminariotp.ddl.models

data class Publisher(
    override val id: Int,
    override val name: String,
    override val slug: String,
    override val gamesCount: Int,
) : Filter
