package com.jordansilva.mywallet.mapper

import com.jordansilva.mywallet.domain.model.BankAccount
import com.jordansilva.mywallet.model.BankAccountView

class BankAccountMapperView : MapperView<BankAccount, BankAccountView> {

    override fun mapFromDomain(type: BankAccount): BankAccountView {
        return BankAccountView(
            name = type.account,
            balance = type.balance,
            transactions = arrayListOf()
        ).apply {
            transactions = type.transactions.map { BankTransactionMapperView().mapFromDomain(it) }
        }
    }
}