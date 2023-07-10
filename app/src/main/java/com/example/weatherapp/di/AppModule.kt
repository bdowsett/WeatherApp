package com.example.weatherapp.di

import com.example.weatherapp.data.WeatherApi
import com.example.weatherapp.data.WeatherRepositoryImpl
import com.example.weatherapp.repository.WeatherRepository
import com.example.weatherapp.util.DateProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val BASE_URL = "https://api.weatherapi.com/"

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val logger = HttpLoggingInterceptor()
        logger.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
            .addInterceptor {
                val request = it.request().newBuilder()
                    .build()
                it.proceed(request)
            }
            .addNetworkInterceptor(logger).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): WeatherApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(WeatherApi::class.java)
    }

    @Singleton
    @Provides
    fun providesWeatherRepo(api: WeatherApi): WeatherRepository{
        return WeatherRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun providesDateProvider(): DateProvider{
        return DateProvider()
    }

}