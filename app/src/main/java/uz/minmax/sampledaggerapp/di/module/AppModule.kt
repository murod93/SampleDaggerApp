package uz.minmax.sampledaggerapp.di.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import uz.minmax.sampledaggerapp.app.App
import javax.inject.Singleton

@Module
abstract class AppModule{
    /**
     * Application application level context.
     */
//    @Singleton
//    @Provides
//    fun provideContext(application: App): Context {
//        return application.applicationContext
//    }

//    @Singleton
//    @Binds   // @Binds, binds the Application instance to Context
//    abstract fun context(appInstance: Application): Context
}