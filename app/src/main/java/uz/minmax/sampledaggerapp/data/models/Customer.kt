package uz.minmax.sampledaggerapp.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "customer_table")
data class Customer(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id:Long=0,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name:String="",

    @SerializedName("password")
    @ColumnInfo(name="customer_password")
    var password:String="",

    @SerializedName("job")
    @ColumnInfo(name = "job")
    var job:String?=null,

    @SerializedName("avatar")
    @ColumnInfo(name="avatar_url")
    var avatar:String?=null
):Serializable