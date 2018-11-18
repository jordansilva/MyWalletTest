package com.jordansilva.mywallet.model

data class BankAccountView(
    var name: String,
    var balance: Double,
    var transactions: List<BankTransactionView>
)