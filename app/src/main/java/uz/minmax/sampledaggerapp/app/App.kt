package uz.minmax.sampledaggerapp.app

import android.app.Application
import uz.minmax.sampledaggerapp.di.component.AppComponent
import uz.minmax.sampledaggerapp.di.component.DaggerAppComponent

//https://github.com/WaheedNazir/Kotlin-MVVM-Architecture/blob/master/app/src/main/java/com/kotlin/mvvm/app/AppExecutors.kt

//http://mobologicplus.com/dagger2-integration-with-android-architecture-component/

//https://github.com/samira-badamestani/MVVM-Dagger-RX-Room/blob/master/app/src/main/java/mvvm/sample/foods/di/module/NetworkModule.kt
open class App: Application() {

    // Instance of the AppComponent that will be used by all the Activities in the project
    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        return DaggerAppComponent.factory().create(applicationContext)
    }
}