package uz.minmax.sampledaggerapp.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "customer_table")
data class Customer(
    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    val id:Long,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name:String?,

    @SerializedName("password")
    @ColumnInfo(name="customer_password")
    val password:String,

    @SerializedName("job")
    @ColumnInfo(name = "job")
    val job:String?,

    @SerializedName("avatar")
    @ColumnInfo(name="avatar_url")
    val avatar:String?
):Serializable