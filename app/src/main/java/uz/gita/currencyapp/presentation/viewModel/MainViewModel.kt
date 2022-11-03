package uz.gita.currencyapp.presentation.viewModel

import androidx.lifecycle.LiveData
import uz.gita.currencyapp.data.model.RateAnorBankModel

interface MainViewModel {
    val timeLiveData: LiveData<String>
    val ratesAnorBankLiveData: LiveData<List<RateAnorBankModel>>
    val errorMessageLiveData: LiveData<String>

    fun loadRatesAnorBank()
}