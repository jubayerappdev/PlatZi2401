package com.creativeitinstitute.platzi2401.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.platzi2401.R
import com.creativeitinstitute.platzi2401.base.BaseFragment
import com.creativeitinstitute.platzi2401.data.models.login.RequestLogin
import com.creativeitinstitute.platzi2401.databinding.FragmentLoginBinding
import com.creativeitinstitute.platzi2401.utils.Keys
import com.creativeitinstitute.platzi2401.utils.PrefManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {



    val viewModel : LoginViewModel by viewModels()

    @Inject
    lateinit var prefManager: PrefManager



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loginResponse.observe(viewLifecycleOwner){

            if (it.isSuccessful){

                prefManager.setPref(Keys.ACCESS_TOKEN, it.body()?.accessToken!!)
                prefManager.setPref(Keys.REFRESH_TOKEN, it.body()?.refreshToken!!)

//                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                findNavController().navigate(R.id.action_loginFragment_to_profileFragment)
            }

        }

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

//            handleLogin("john@mail.com","changeme")
            handleLogin("fahim@gmail.com","123456")
        }
    }

    private fun handleLogin(email: String, password: String) {
        val requestLogin = RequestLogin(email = email, password = password)

        viewModel.login(requestLogin)

    }


}