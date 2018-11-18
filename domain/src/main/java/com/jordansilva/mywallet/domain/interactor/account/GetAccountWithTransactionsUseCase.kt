package com.jordansilva.mywallet.domain.interactor.account

import com.jordansilva.mywallet.domain.interactor.BaseUseCase
import com.jordansilva.mywallet.domain.model.BankAccount
import com.jordansilva.mywallet.domain.repository.BankAccountRepository

class GetAccountWithTransactionsUseCase(private var repository: BankAccountRepository) : BaseUseCase() {

    fun execute(): BankAccount {
        try {
            val bankAccount = repository.getBankAccount()
            bankAccount.computeTransactionsBalance()

            return bankAccount
        } catch (exception: Exception) {
            throw exception
        }
    }
}