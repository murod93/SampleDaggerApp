package uz.minmax.sampledaggerapp.di.module

import dagger.Binds
import dagger.Module
import uz.minmax.sampledaggerapp.data.local.repository.CustomerRepository
import uz.minmax.sampledaggerapp.data.local.repository.CustomerRepositoryImpl


/**
 * @author Murodjon
 */
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideCustomerRepository(customerRepository: CustomerRepositoryImpl):CustomerRepository
}