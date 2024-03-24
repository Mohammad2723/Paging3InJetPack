package com.github.ebrahimi16153.paging3injetpack.di

import com.github.ebrahimi16153.paging3injetpack.api.ApiService
import com.github.ebrahimi16153.paging3injetpack.util.Constant
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Singleton
    @Provides
    fun provideTime() = Constant.TIMEOUT

    @Singleton
    @Provides
    fun provideBaseUrl() = Constant.BASE_URL


    @Singleton
    @Provides
    fun provideClient(time: Long): OkHttpClient =
        OkHttpClient.Builder()
            .writeTimeout(time, TimeUnit.SECONDS)
            .readTimeout(time, TimeUnit.SECONDS)
            .connectTimeout(time, TimeUnit.SECONDS)
            .callTimeout(time,TimeUnit.SECONDS)
            .build()

    @Singleton
    @Provides
    fun provideMediaType(): MediaType = MediaType.get("application/json")

    @Singleton
    @Provides
    fun provideJson() = Json { ignoreUnknownKeys = true }


    @Singleton
    @Provides
    fun provideApiService(
        client: OkHttpClient,
        baseUrl: String,
        mediaType: MediaType,
        json: Json
    ): ApiService =
        Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(json.asConverterFactory(mediaType))
            .build()
            .create(ApiService::class.java)


}