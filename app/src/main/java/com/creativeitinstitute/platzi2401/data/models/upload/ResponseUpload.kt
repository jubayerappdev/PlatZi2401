package com.creativeitinstitute.platzi2401.data.models.upload


import com.google.gson.annotations.SerializedName

data class ResponseUpload(
    @SerializedName("filename")
    var filename: String?,
    @SerializedName("location")
    var location: String?,
    @SerializedName("originalname")
    var originalname: String?
)