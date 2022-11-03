package uz.gita.currencyapp.domain.useCase

import kotlinx.coroutines.flow.Flow
import uz.gita.currencyapp.data.model.RateAnorBankModel

interface CurrencyUseCase {
    fun getRatesAnorBank(): Flow<Result<List<RateAnorBankModel>>>
}