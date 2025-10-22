package com.example.seminariotp.ddl.models

interface Filter {
    val id: Int
    val name: String
    val slug: String
    val gamesCount: Int
}