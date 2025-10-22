package com.example.seminariotp.ddl.models

data class Store(
    override val id: Int,
    override val name: String,
    override val slug: String,
    override val gamesCount: Int,
    val domain: String? = null,
) : Filter
