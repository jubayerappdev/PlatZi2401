package com.creativeitinstitute.platzi2401.ui.upload

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.creativeitinstitute.platzi2401.data.models.login.RequestLogin
import com.creativeitinstitute.platzi2401.data.models.login.ResponseLogin
import com.creativeitinstitute.platzi2401.data.models.register.RequestRegistration
import com.creativeitinstitute.platzi2401.data.models.register.ResponseRegistration
import com.creativeitinstitute.platzi2401.data.models.upload.ResponseUpload
import com.creativeitinstitute.platzi2401.data.repositories.AuthRepository
import com.creativeitinstitute.platzi2401.data.repositories.UploadRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class UploadViewModel @Inject constructor(private val repository: UploadRepository) :ViewModel() {

    private val _response = MutableLiveData<Response<ResponseUpload>>()
    val uploadResponse:LiveData<Response<ResponseUpload>> = _response


    fun upload(file : MultipartBody.Part) {

        viewModelScope.launch {


            _response.postValue(repository.upload(file))
        }


    }

}