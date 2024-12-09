package com.creativeitinstitute.platzi2401.services

import com.creativeitinstitute.platzi2401.data.models.profile.ResponseProfile
import retrofit2.Response
import retrofit2.http.GET

interface UserServices {




    @GET("auth/profile")
    suspend fun profile(): Response<ResponseProfile>
}