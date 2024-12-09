package com.creativeitinstitute.platzi2401.utils

import android.widget.ImageView
import coil.load
import coil.request.CachePolicy
import com.creativeitinstitute.platzi2401.R


fun ImageView.load(imageUrl:String){

    this.load(imageUrl){
        placeholder(R.drawable.placeholder)
        error(R.drawable.placeholder_error)
        diskCachePolicy(CachePolicy.ENABLED)
    }



}