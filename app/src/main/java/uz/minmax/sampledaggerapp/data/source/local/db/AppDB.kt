package uz.minmax.sampledaggerapp.data.source.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.minmax.sampledaggerapp.data.source.local.dao.CustomerDao
import uz.minmax.sampledaggerapp.data.models.Customer

/**
 * @author Murodjon Abdukholikov
 */
@Database(entities = [Customer::class], version = 1, exportSchema = false)
abstract class AppDB : RoomDatabase() {

    abstract fun customerDao(): CustomerDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        private const val DB_NAME:String = "dagger_app_db"

        @Volatile
        private var INSTANCE: AppDB? = null

        fun getDatabase(context: Context): AppDB {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDB::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}