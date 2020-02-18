package uz.minmax.sampledaggerapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.minmax.sampledaggerapp.data.source.local.dao.UserDao

@Database(entities = arrayOf(UserDao::class), version = AppDB.VERSION)
abstract class AppDB:RoomDatabase(){

    companion object{
        internal const val VERSION = 1
    }
}