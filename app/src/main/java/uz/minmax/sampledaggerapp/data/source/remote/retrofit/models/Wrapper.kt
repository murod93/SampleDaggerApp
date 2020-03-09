package uz.minmax.sampledaggerapp.data.source.remote.retrofit.models

import com.google.gson.annotations.SerializedName

data class Wrapper<T>(

    @field:SerializedName("data")
    val data: T? = null,

    @field:SerializedName("msgCode")
    val msgCode: String? = null
)