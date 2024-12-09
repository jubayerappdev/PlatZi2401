package com.creativeitinstitute.platzi2401.data.repositories

import com.creativeitinstitute.platzi2401.data.models.profile.ResponseProfile
import com.creativeitinstitute.platzi2401.services.UserServices
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val service: UserServices) {


   suspend fun profile() : Response<ResponseProfile>{

        return service.profile()
    }


}