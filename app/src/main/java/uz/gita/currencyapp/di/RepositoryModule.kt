package uz.gita.currencyapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.currencyapp.data.repository.CurrencyRepository
import uz.gita.currencyapp.data.repository.CurrencyRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @[Binds Singleton]
    fun getCurrencyRepository(impl: CurrencyRepositoryImpl): CurrencyRepository
}