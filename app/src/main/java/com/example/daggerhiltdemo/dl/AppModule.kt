package com.example.daggerhiltdemo.dl

import com.example.daggerhiltdemo.Network.PostApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Url
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
     @Provides
    fun provideBaseUrl():String = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun provideRetrofitBuilder(baseUrl: String): Retrofit=
        Retrofit.Builder().baseUrl(baseUrl).
        addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    fun providesPostApiService(retrofit: Retrofit):PostApiService =
        retrofit.create(PostApiService::class.java)
}