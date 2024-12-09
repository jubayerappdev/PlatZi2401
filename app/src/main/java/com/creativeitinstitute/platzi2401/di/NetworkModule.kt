package com.creativeitinstitute.platzi2401.di

import com.creativeitinstitute.platzi2401.services.AuthServices
import com.creativeitinstitute.platzi2401.services.UploadServices
import com.creativeitinstitute.platzi2401.services.UserServices
import com.creativeitinstitute.platzi2401.utils.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
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
    @Provides
    @Singleton
    fun providesUpload(retrofit: Retrofit.Builder) :UploadServices{

        return retrofit.build().create(UploadServices::class.java)
    }

    @Provides
    @Singleton
    fun providesHttpClient(authInterceptor: AuthInterceptor) :OkHttpClient{

        return OkHttpClient.Builder().addInterceptor(interceptor = authInterceptor).build()
    }

    @Provides
    @Singleton
    fun providesUserService(retrofit: Retrofit.Builder, client: OkHttpClient) :UserServices{

        return retrofit.client(client).build().create(UserServices::class.java)
    }


}