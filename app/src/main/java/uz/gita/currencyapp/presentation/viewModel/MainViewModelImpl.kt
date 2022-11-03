package uz.gita.currencyapp.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.currencyapp.data.model.RateAnorBankModel
import uz.gita.currencyapp.domain.useCase.CurrencyUseCase
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor(
    private val useCase: CurrencyUseCase
) : ViewModel(), MainViewModel {
    override val timeLiveData = MutableLiveData<String>()
    override val ratesAnorBankLiveData = MutableLiveData<List<RateAnorBankModel>>()
    override val errorMessageLiveData = MutableLiveData<String>()

    init {
        loadRatesAnorBank()
    }

    override fun loadRatesAnorBank() {
        useCase.getRatesAnorBank().onEach {
            it.onSuccess { rates ->
                timeLiveData.value = SimpleDateFormat("hh:mm:ss").format(Date()).toString()
                ratesAnorBankLiveData.value = rates
            }
            it.onFailure { error ->
                errorMessageLiveData.value = error.message
            }
        }.launchIn(viewModelScope)
    }
}