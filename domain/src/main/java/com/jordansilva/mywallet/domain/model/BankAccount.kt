package com.jordansilva.mywallet.domain.model

import java.util.*

class BankAccount(
    var account: String,
    var balance: Double,
    var transactions: ArrayList<BankTransaction> = arrayListOf()
) : BaseModel() {

    fun computeTransactionsBalance() {
        var currAmmount = balance

        transactions.sortByDescending { it.date }
        transactions.forEach {
            it.afterAmount = currAmmount
            currAmmount -= it.amount
        }
    }

}