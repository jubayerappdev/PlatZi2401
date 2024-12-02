package com.creativeitinstitute.platzi2401.data.repositories

import com.creativeitinstitute.platzi2401.data.models.login.RequestLogin
import com.creativeitinstitute.platzi2401.data.models.login.ResponseLogin
import com.creativeitinstitute.platzi2401.data.models.register.RequestRegistration
import com.creativeitinstitute.platzi2401.data.models.register.ResponseRegistration
import com.creativeitinstitute.platzi2401.services.AuthServices
import retrofit2.Response
import javax.inject.Inject

class AuthRepository @Inject constructor(private val service: AuthServices) {


   suspend fun login(requestLogin: RequestLogin) : Response<ResponseLogin>{

        return service.login(requestLogin)
    }


    suspend fun registration(request: RequestRegistration) : Response<ResponseRegistration>{

        return service.registration(request)
    }
}