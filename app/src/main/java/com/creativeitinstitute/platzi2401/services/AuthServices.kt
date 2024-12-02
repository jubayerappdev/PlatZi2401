package com.creativeitinstitute.platzi2401.services

import com.creativeitinstitute.platzi2401.data.models.login.RequestLogin
import com.creativeitinstitute.platzi2401.data.models.login.ResponseLogin
import com.creativeitinstitute.platzi2401.data.models.register.RequestRegistration
import com.creativeitinstitute.platzi2401.data.models.register.ResponseRegistration
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthServices {


    @POST("auth/login")
    suspend fun login(@Body requestLogin: RequestLogin): Response<ResponseLogin>

    @POST("users/")
    suspend fun registration(@Body request: RequestRegistration): Response<ResponseRegistration>
}