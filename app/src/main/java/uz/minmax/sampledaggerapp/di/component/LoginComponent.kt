package uz.minmax.sampledaggerapp.di.component

import dagger.Subcomponent
import uz.minmax.sampledaggerapp.di.scopes.ActivityScope
import uz.minmax.sampledaggerapp.ui.LoginActivity

@ActivityScope
@Subcomponent
interface LoginComponent{

    @Subcomponent.Factory
    interface Factory{
        fun create():LoginComponent
    }

    fun inject(activity:LoginActivity)
}