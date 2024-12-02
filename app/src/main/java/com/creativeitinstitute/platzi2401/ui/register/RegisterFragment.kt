package com.creativeitinstitute.platzi2401.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.platzi2401.R
import com.creativeitinstitute.platzi2401.base.BaseFragment
import com.creativeitinstitute.platzi2401.data.models.register.RequestRegistration
import com.creativeitinstitute.platzi2401.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val viewModel: RegistrationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.btnRegister.setOnClickListener {
            viewModel.registrationResponse.observe(viewLifecycleOwner){
                if (it.isSuccessful){
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                }
            }

            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val imageAvater =
                "https://source.boomplaymusic.com/buzzgroup1/M00/3D/A7/rBEevGLXpSiAU3jLAAIwlwO9nlo220.jpg"

            val registerRequest = RequestRegistration(
                avatar = imageAvater,
                email = email,
                name = name,
                password = password
            )
            viewModel.register(registerRequest)

        }


    }


}