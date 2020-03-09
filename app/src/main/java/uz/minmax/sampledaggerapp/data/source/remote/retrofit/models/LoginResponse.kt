package uz.minmax.sampledaggerapp.data.source.remote.retrofit.models

import com.google.gson.annotations.SerializedName
sealed class LoginResponse {
    data class LoginData(

        @field:SerializedName("hostname")
        val hostname: String? = null,

        @field:SerializedName("role")
        val role:Role? = null,

        @field:SerializedName("tokens")
        val tokens: Tokens? = null,

        @field:SerializedName("user")
        val user: User? = null
    )

    data class Role(
        @field:SerializedName("displayName")
        val displayName: String? = null,

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("description")
        val description: String? = null,

        @field:SerializedName("id")
        val id: String? = null
    )

    data class Tokens(

        @field:SerializedName("accessToken")
        val accessToken: String? = null,

        @field:SerializedName("refreshToken")
        val refreshToken: String? = null
    ) {
        fun isEmpty(): Boolean {
            return accessToken.isNullOrEmpty() || refreshToken.isNullOrEmpty()
        }
    }

    data class User(
        @field:SerializedName("lastName")
        val lastName: String? = null,

        @field:SerializedName("lastLogin")
        val lastLogin: String? = null,

        @field:SerializedName("createdUserId")
        val createdUserId: String? = null,

        @field:SerializedName("roleId")
        val roleId: String? = null,

        @field:SerializedName("nadirImageUrl")
        val nadirImageUrl: String? = null,

        @field:SerializedName("verified")
        val verified: Boolean? = null,

        @field:SerializedName("vendorId")
        val vendorId: String? = null,

        @field:SerializedName("active")
        val active: Boolean? = null,

        @field:SerializedName("firstName")
        val firstName: String? = null,

        @field:SerializedName("createdAt")
        val createdAt: String? = null,

        @field:SerializedName("blocked")
        val blocked: Boolean? = null,

        @field:SerializedName("imageUrl")
        val imageUrl: String? = null,

        @field:SerializedName("nadirThumbUrl")
        val nadirThumbUrl: String? = null,

        @field:SerializedName("id")
        val id: String? = null,

        @field:SerializedName("thumbUrl")
        val thumbUrl: String? = null,

        @field:SerializedName("email")
        val email: String? = null,

        @field:SerializedName("invitationCode")
        val invitationCode: String? = null,

        @field:SerializedName("username")
        val username: String? = null,

        @field:SerializedName("updatedAt")
        val updatedAt: String? = null
    )
}

