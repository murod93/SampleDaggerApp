package uz.minmax.sampledaggerapp.app

import android.app.Application
import uz.minmax.sampledaggerapp.di.component.AppComponent
import uz.minmax.sampledaggerapp.di.component.DaggerAppComponent

open class App: Application() {

    val appComponent:AppComponent by lazy{
        DaggerAppComponent.factory().create(applicationContext)
    }
}