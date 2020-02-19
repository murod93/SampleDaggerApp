package uz.minmax.sampledaggerapp.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import uz.minmax.sampledaggerapp.data.local.dao.CustomerDao
import uz.minmax.sampledaggerapp.data.local.db.AppDB
import javax.inject.Singleton

/**
 * @author Murodjon
 */

@Module
class RoomDBModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(context: Context): AppDB {
        return Room
            .databaseBuilder(context, AppDB::class.java, AppDB.DB_NAME)
            .build()
    }

    @Provides
    fun provideCustomerDao(appDataBase: AppDB): CustomerDao {
        return appDataBase.customerDao()
    }
}