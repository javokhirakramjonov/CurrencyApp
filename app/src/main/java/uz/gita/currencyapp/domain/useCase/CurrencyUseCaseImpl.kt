package uz.gita.currencyapp.domain.useCase

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.currencyapp.data.model.RateAnorBankModel
import uz.gita.currencyapp.data.repository.CurrencyRepository
import javax.inject.Inject

class CurrencyUseCaseImpl @Inject constructor(
    private val repository: CurrencyRepository
) : CurrencyUseCase {
    override fun getRatesAnorBank(): Flow<Result<List<RateAnorBankModel>>> = flow {
        emit(repository.getRatesOfAnorBank())
    }.catch {
        Log.d("TTT", it.message.toString())
        emit(Result.failure(it))
    }.flowOn(Dispatchers.IO)
}