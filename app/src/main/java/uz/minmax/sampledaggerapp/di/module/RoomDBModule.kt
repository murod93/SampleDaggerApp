package uz.minmax.sampledaggerapp.di.module

import android.content.Context
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
    fun provideRoomDatabase(context: Context) = AppDB.getDatabase(context)

    @Singleton
    @Provides
    fun provideCustomerDao(appDataBase: AppDB): CustomerDao = appDataBase.customerDao()
}