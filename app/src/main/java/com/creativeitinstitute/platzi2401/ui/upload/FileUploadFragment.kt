package com.creativeitinstitute.platzi2401.ui.upload

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import com.creativeitinstitute.platzi2401.base.BaseFragment
import com.creativeitinstitute.platzi2401.databinding.FragmentFileUploadBinding
import com.github.dhaval2404.imagepicker.ImagePicker


class FileUploadFragment : BaseFragment<FragmentFileUploadBinding>(FragmentFileUploadBinding::inflate) {

    val viewModel : UploadViewModel by viewModels ()

   private var fileUri  : Uri? = null

    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            if (resultCode == Activity.RESULT_OK) {
                //Image Uri will not be null for RESULT_OK
                val fileUri = data?.data!!

                binding.profileImageView.setImageURI(fileUri)
                binding.uploadBtn.visibility = View.VISIBLE
            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(requireContext(), ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
                binding.uploadBtn.visibility = View.INVISIBLE
            } else {
                Toast.makeText(requireContext(), "Task Cancelled", Toast.LENGTH_SHORT).show()
                binding.uploadBtn.visibility = View.INVISIBLE
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.pickAnImage.setOnClickListener {

            ImagePicker.with(this)
                .compress(512)         //Final image size will be less than 1 MB(Optional)
                .maxResultSize(512, 512)  //Final image resolution will be less than 1080 x 1080(Optional)
                .createIntent { intent ->
                    startForProfileImageResult.launch(intent)
                }

        }


        binding.uploadBtn.setOnClickListener {
            fileUri?.let { fileUri->

                uploadFile(fileUri)

            }


        }
    }

    private fun uploadFile(fileUri: Uri) {


    }


}