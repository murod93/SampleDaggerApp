package uz.minmax.sampledaggerapp.di.component

import dagger.Module

@Module(subcomponents = [LoginComponent::class, CustomerComponent::class])
class AppSubComponent