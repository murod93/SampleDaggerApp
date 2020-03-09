package uz.minmax.sampledaggerapp.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import uz.minmax.sampledaggerapp.ui.MainActivity
import uz.minmax.sampledaggerapp.di.module.AppModule
import uz.minmax.sampledaggerapp.di.module.NetworkModule
import uz.minmax.sampledaggerapp.di.module.RepositoryModule
import uz.minmax.sampledaggerapp.di.module.RoomDBModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, AppSubComponent::class, RoomDBModule::class, RepositoryModule::class, NetworkModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context):AppComponent
    }

    fun loginComponent():LoginComponent.Factory

    fun customerComponent():CustomerComponent.Factory
}