package com.creativeitinstitute.platzi2401.data.repositories

import com.creativeitinstitute.platzi2401.data.models.profile.ResponseProfile
import com.creativeitinstitute.platzi2401.data.models.upload.ResponseUpload
import com.creativeitinstitute.platzi2401.services.UploadServices
import com.creativeitinstitute.platzi2401.services.UserServices
import okhttp3.MultipartBody
import retrofit2.Response
import javax.inject.Inject

class UploadRepository @Inject constructor(private val service: UploadServices) {


   suspend fun upload(file:MultipartBody.Part) : Response<ResponseUpload>{

        return service.upload(file)
    }


}