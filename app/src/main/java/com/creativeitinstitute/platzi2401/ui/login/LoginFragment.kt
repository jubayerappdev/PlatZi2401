package com.creativeitinstitute.platzi2401.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.creativeitinstitute.platzi2401.R
import com.creativeitinstitute.platzi2401.data.models.login.RequestLogin
import com.creativeitinstitute.platzi2401.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding

    val viewModel : LoginViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentLoginBinding.inflate(inflater,container,false)
        viewModel.loginResponse.observe(viewLifecycleOwner){

            if (it.isSuccessful){
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }

        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            handleLogin("john@mail.com","changeme")
        }
    }

    private fun handleLogin(email: String, password: String) {
        val requestLogin = RequestLogin(email = email, password = password)

        viewModel.login(requestLogin)

    }


}