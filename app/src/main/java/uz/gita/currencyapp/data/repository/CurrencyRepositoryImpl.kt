package uz.gita.currencyapp.data.repository

import android.util.Log
import uz.gita.currencyapp.data.model.RateAnorBankModel
import uz.gita.currencyapp.data.remote.api.AnorBankApi
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val anorBankApi: AnorBankApi,
) : CurrencyRepository {
    override suspend fun getRatesOfAnorBank(): Result<List<RateAnorBankModel>> {
        Log.d("TTT", "Started")
        val response = anorBankApi.getRates()
        response.body()!!.list.forEach { Log.d("TTT", it.toString()) }
        return when (response.code()) {
            200 -> {
                Result.success(response.body()!!.list.map { it.mapToLocal() })
            }
            else -> {
                Result.failure(Exception(response.errorBody().toString()))
            }
        }
    }
}