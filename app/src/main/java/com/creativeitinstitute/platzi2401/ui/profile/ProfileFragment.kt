package com.creativeitinstitute.platzi2401.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import coil.load
import com.creativeitinstitute.platzi2401.base.BaseFragment
import com.creativeitinstitute.platzi2401.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    private val viewModel : ProfileViewModel by viewModels ()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.profileResponse.observe(viewLifecycleOwner){

            if (!it.isSuccessful) return@observe

            binding.apply {

                it.body()?.let {profile->

                    nameTextView.text = profile.name
                    emailTextView.text = profile.email
                    roleTextView.text = profile.role

                    profileImageView.load(profile.avatar)



                }

            }
        }



    }



}