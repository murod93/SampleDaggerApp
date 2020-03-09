package uz.minmax.sampledaggerapp.data.source.remote.retrofit.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import uz.minmax.sampledaggerapp.data.source.remote.retrofit.models.LoginRequest
import uz.minmax.sampledaggerapp.data.source.remote.retrofit.models.LoginResponse
import uz.minmax.sampledaggerapp.data.source.remote.retrofit.models.ResetRequest
import uz.minmax.sampledaggerapp.data.source.remote.retrofit.models.Wrapper

private const val PRIVATE_URL = "aun/authn"
private const val PUBLIC_URL = "aun/p/authn"

interface AuthApi {
    @POST("$PUBLIC_URL/login")
    suspend fun login(@Body data: LoginRequest): Response<Wrapper<LoginResponse.LoginData>>

    @POST("$PUBLIC_URL/refresh")
    fun refresh(@Body data: LoginResponse.Tokens): Call<Wrapper<LoginResponse.Tokens>>

    @GET("$PRIVATE_URL/logout")
    suspend fun logout(): Response<Unit>

    @GET("$PRIVATE_URL/info")
    suspend fun getInfo(): Response<Unit>

    @POST("$PUBLIC_URL/getResetPasswordCode")
    suspend fun reset(@Body data: ResetRequest): Response<Wrapper<String>>
}