package com.jordansilva.mywallet.mapper

import com.jordansilva.mywallet.domain.model.BankTransaction
import com.jordansilva.mywallet.model.BankTransactionView

class BankTransactionMapperView : MapperView<BankTransaction, BankTransactionView> {

    override fun mapFromDomain(type: BankTransaction): BankTransactionView {

        return BankTransactionView(
            id = type.id,
            amount = type.amount,
            description = type.description,
            otherAccount = type.otherAccount,
            date = type.date
        )
    }
}