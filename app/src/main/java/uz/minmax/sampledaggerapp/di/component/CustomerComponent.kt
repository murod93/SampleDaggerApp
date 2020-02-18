package uz.minmax.sampledaggerapp.di.component

import dagger.Subcomponent
import uz.minmax.sampledaggerapp.di.scopes.ActivityScope
import uz.minmax.sampledaggerapp.ui.CustomerDetailsFragment
import uz.minmax.sampledaggerapp.ui.CustomerListFragment
import uz.minmax.sampledaggerapp.ui.MainActivity
import uz.minmax.sampledaggerapp.ui.NewCustomerFragment

@ActivityScope
@Subcomponent
interface CustomerComponent {
    @Subcomponent.Factory
    interface Factory{
        fun create():CustomerComponent
    }

    fun inject(activity:MainActivity)

    fun inject(fragment:CustomerDetailsFragment)

    fun inject(fragment: CustomerListFragment)

    fun inject(fragment: NewCustomerFragment)
}