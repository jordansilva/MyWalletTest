package com.jordansilva.mywallet.domain.repository

import com.jordansilva.mywallet.domain.model.BankAccount

interface BankAccountRepository {
    fun getBankAccount(): BankAccount
}