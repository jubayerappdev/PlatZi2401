package com.creativeitinstitute.platzi2401.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.creativeitinstitute.platzi2401.data.models.login.RequestLogin
import com.creativeitinstitute.platzi2401.data.models.login.ResponseLogin
import com.creativeitinstitute.platzi2401.data.models.profile.ResponseProfile
import com.creativeitinstitute.platzi2401.data.models.register.RequestRegistration
import com.creativeitinstitute.platzi2401.data.models.register.ResponseRegistration
import com.creativeitinstitute.platzi2401.data.repositories.AuthRepository
import com.creativeitinstitute.platzi2401.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repository: UserRepository) :ViewModel() {

    private val _response = MutableLiveData<Response<ResponseProfile>>()
    val profileResponse:LiveData<Response<ResponseProfile>> = _response

    init {
        profile()
    }

   private fun profile() {

        viewModelScope.launch {


            _response.postValue(repository.profile())
        }


    }

}