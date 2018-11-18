package com.jordansilva.mywallet.domain.model

import java.util.*

class BankAccount(
    var account: String,
    var balance: Double,
    var transactions: ArrayList<BankTransaction> = arrayListOf()
) : BaseModel() {

    fun addTransaction(account: String, amount: Double, description: String?, date: Date?): BankTransaction {
        var dateTransaction = date ?: Calendar.getInstance().time

        val t = BankTransaction(amount, description, account, dateTransaction)
        transactions.add(t)
        return t
    }

}