package uz.gita.currencyapp.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.currencyapp.R
import uz.gita.currencyapp.data.model.RateAnorBankModel
import uz.gita.currencyapp.databinding.ScreenMainBinding
import uz.gita.currencyapp.presentation.viewModel.MainViewModel
import uz.gita.currencyapp.presentation.viewModel.MainViewModelImpl

@AndroidEntryPoint
class MainScreen : Fragment(R.layout.screen_main) {

    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()
    private val binding by viewBinding(ScreenMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        buttonRefresh.setOnClickListener { viewModel.loadRatesAnorBank() }
        viewModel.errorMessageLiveData.observe(viewLifecycleOwner, errorMessageObserver)
        viewModel.ratesAnorBankLiveData.observe(viewLifecycleOwner, ratesObserver)
        viewModel.timeLiveData.observe(viewLifecycleOwner, timeObserver)
    }

    private val errorMessageObserver = Observer<String> {
        Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
    }

    private val ratesObserver = Observer<List<RateAnorBankModel>> {
        binding.apply {
            ((rateUSD.getChildAt(1) as LinearLayoutCompat).getChildAt(1) as AppCompatTextView).text = "${it[1].rateBuy}"
            ((rateRUB.getChildAt(1) as LinearLayoutCompat).getChildAt(1) as AppCompatTextView).text = "${it[0].rateBuy}"
            ((rateEUR.getChildAt(1) as LinearLayoutCompat).getChildAt(1) as AppCompatTextView).text = "${it[2].rateBuy}"

            ((rateUSD.getChildAt(2) as LinearLayoutCompat).getChildAt(1) as AppCompatTextView).text =
                "${it[1].rateSell}"
            ((rateRUB.getChildAt(2) as LinearLayoutCompat).getChildAt(1) as AppCompatTextView).text =
                "${it[0].rateSell}"
            ((rateEUR.getChildAt(2) as LinearLayoutCompat).getChildAt(1) as AppCompatTextView).text =
                "${it[2].rateSell}"

            ((rateUSD.getChildAt(3) as LinearLayoutCompat).getChildAt(1) as AppCompatTextView).text = "${it[1].rateCB}"
            ((rateRUB.getChildAt(3) as LinearLayoutCompat).getChildAt(1) as AppCompatTextView).text = "${it[0].rateCB}"
            ((rateEUR.getChildAt(3) as LinearLayoutCompat).getChildAt(1) as AppCompatTextView).text = "${it[2].rateCB}"

        }
    }

    private val timeObserver = Observer<String> {
        binding.textUpdatedTime.text = "Last updated $it"
    }

}