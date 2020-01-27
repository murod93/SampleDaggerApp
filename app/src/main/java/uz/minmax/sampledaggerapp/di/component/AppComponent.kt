package uz.minmax.sampledaggerapp.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import uz.minmax.sampledaggerapp.MainActivity
import uz.minmax.sampledaggerapp.di.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, AppSubComponent::class])
interface AppComponent {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context):AppComponent
    }

    fun loginComponent():LoginComponent.Factory

    fun inject(activity: MainActivity)
}