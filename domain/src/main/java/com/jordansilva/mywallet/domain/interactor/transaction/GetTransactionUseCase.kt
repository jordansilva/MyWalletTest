package com.jordansilva.mywallet.domain.interactor.transaction

import com.jordansilva.mywallet.domain.interactor.BaseUseCase
import com.jordansilva.mywallet.domain.model.BankTransaction
import java.util.*

class GetTransactionUseCase(private var repository: String) : BaseUseCase() {

    fun execute(): BankTransaction {
        try {
            return BankTransaction(
                amount = 0.0,
                description = "",
                otherAccount = "XPTO",
                date = Calendar.getInstance().time
            )

        } catch (exception: Exception) {
            throw exception
        }
    }
}