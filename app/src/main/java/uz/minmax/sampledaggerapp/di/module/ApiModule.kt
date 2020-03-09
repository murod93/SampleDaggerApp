package uz.minmax.sampledaggerapp.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import uz.minmax.sampledaggerapp.data.source.remote.retrofit.api.AuthApi
import javax.inject.Singleton

/**
 * @author Murodjon Abdukholiqov
 */

@Module
class ApiModule {
    @Singleton
    @Provides
    fun provideAuthApi(retrofit: Retrofit){
    }

    @Singleton
    @Provides
    fun getAuthApi(retrofit: Retrofit): AuthApi = retrofit.create(AuthApi::class.java)

    @Singleton
    @Provides
    fun provideCustomerApi(retrofit: Retrofit){

    }
}