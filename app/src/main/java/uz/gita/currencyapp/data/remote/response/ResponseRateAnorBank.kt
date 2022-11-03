package uz.gita.currencyapp.data.remote.response

import uz.gita.currencyapp.data.model.RateAnorBankModel

data class ResponseRateAnorBank(
    val list: List<ResponseRate>
)

data class ResponseRate(
    val baseCode: String,
    val code: String,
    val fractDigits: Int,
    val scale: Int,
    val rateDate: String,
    val rateCB: Double,
    val baseFractDigits: Int,
    val isoCode: String,
    val baseISO: String,
    val rateBuy: Double,
    val name: String,
    val rateSell: Double,
    val baseName: String
) {
    fun mapToLocal(): RateAnorBankModel = RateAnorBankModel(baseName, rateBuy, rateSell, rateCB)
}
