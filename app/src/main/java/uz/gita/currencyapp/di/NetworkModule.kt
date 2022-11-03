package uz.gita.currencyapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.gita.currencyapp.data.remote.api.AnorBankApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @[Provides Singleton]
    fun provideOkHttp(): OkHttpClient = OkHttpClient
        .Builder()
        .build()

    @[Provides Singleton]
    fun provideRetrofitAnorbank(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://retail.anorbank.uz/api/v1/")
        .build()

    @[Provides Singleton]
    fun provideApiAnorBank(retrofit: Retrofit): AnorBankApi = retrofit.create(AnorBankApi::class.java)
}