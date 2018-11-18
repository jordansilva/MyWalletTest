package com.jordansilva.mywallet.model

import java.util.*

data class BankTransactionView(
    var id: String, var amount: Double,
    var description: String?, var otherAccount: String, var date: Date
) {
    var balanceAfter: Double? = null
    var balanceBefore: Double? = null
}