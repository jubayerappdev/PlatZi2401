package com.creativeitinstitute.platzi2401.data.models.login


import com.google.gson.annotations.SerializedName

data class ResponseLogin(
    @SerializedName("access_token")
    var accessToken: String?,
    @SerializedName("refresh_token")
    var refreshToken: String?
)