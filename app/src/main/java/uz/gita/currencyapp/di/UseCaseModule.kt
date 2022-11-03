package uz.gita.currencyapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.currencyapp.domain.useCase.CurrencyUseCase
import uz.gita.currencyapp.domain.useCase.CurrencyUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {
    @[Binds Singleton]
    fun getCurrencyUseCase(impl: CurrencyUseCaseImpl): CurrencyUseCase
}