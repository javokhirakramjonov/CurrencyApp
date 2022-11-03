package uz.gita.currencyapp.data.repository

import uz.gita.currencyapp.data.model.RateAnorBankModel

interface CurrencyRepository {
    suspend fun getRatesOfAnorBank(): Result<List<RateAnorBankModel>>
}