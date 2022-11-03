package uz.gita.currencyapp.data.model

data class RateAnorBankModel(
    val baseName: String,
    val rateBuy: Double,
    val rateSell: Double,
    val rateCB: Double
)