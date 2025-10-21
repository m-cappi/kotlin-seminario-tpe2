package com.example.seminariotp.di

import com.example.seminariotp.BuildConfig
import com.example.seminariotp.ddl.GameApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class GameModule {
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.GAMES_API_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

    @Provides
    fun provideGameApi(
        retrofit: Retrofit
    ): GameApi {
        return retrofit.create(GameApi::class.java)
    }

}