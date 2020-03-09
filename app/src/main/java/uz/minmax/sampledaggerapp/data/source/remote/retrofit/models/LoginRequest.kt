package uz.minmax.sampledaggerapp.data.source.remote.retrofit.models

import com.google.gson.annotations.SerializedName


data class LoginRequest(
    @SerializedName("username")
    val userName: String,
    @SerializedName("password")
    val password: String
)