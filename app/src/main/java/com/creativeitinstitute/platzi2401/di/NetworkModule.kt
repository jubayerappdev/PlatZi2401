package com.creativeitinstitute.platzi2401.di

import com.creativeitinstitute.platzi2401.services.AuthServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder{

        return Retrofit.Builder()
            .baseUrl("https://api.escuelajs.co/api/v1/")
            .addConverterFactory(
            GsonConverterFactory.create()
        )
    }

    @Provides
    @Singleton
    fun providesAuthService(retrofit: Retrofit.Builder) :AuthServices{

        return retrofit.build().create(AuthServices::class.java)
    }
}