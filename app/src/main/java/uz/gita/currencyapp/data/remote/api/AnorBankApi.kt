package uz.gita.currencyapp.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import uz.gita.currencyapp.data.remote.response.ResponseRateAnorBank

interface AnorBankApi {
    @GET("currencies/rates/exchange")
    suspend fun getRates(): Response<ResponseRateAnorBank>
}