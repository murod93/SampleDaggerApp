package uz.minmax.sampledaggerapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.minmax.sampledaggerapp.data.local.dao.CustomerDao
import uz.minmax.sampledaggerapp.data.models.Customer

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = [Customer::class], version = 1, exportSchema = false)
abstract class AppDB : RoomDatabase() {

    abstract fun customerDao(): CustomerDao

    companion object {
//        // Singleton prevents multiple instances of database opening at the
//        // same time.
        val DB_NAME:String = "dagger_app_db"
//
//        @Volatile
//        private var INSTANCE: AppDB? = null
//
//        fun getDatabase(context: Context): AppDB {
//            val tempInstance = INSTANCE
//            if (tempInstance != null) {
//                return tempInstance
//            }
//            synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDB::class.java,
//                    "dagger_app_db"
//                ).build()
//                INSTANCE = instance
//                return instance
//            }
//        }
    }
}