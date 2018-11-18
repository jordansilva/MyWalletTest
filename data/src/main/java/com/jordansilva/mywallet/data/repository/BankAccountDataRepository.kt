package com.jordansilva.mywallet.data.repository

import android.content.res.AssetManager
import com.google.gson.GsonBuilder
import com.jordansilva.mywallet.domain.model.BankAccount
import com.jordansilva.mywallet.domain.repository.BankAccountRepository

class BankAccountDataRepository constructor(private val assetManager: AssetManager) : BankAccountRepository {

    private val TRANSACTION_FILE = "transactions.json"

    override fun getBankAccount(): BankAccount {
        var text: String

        assetManager.open(TRANSACTION_FILE).bufferedReader().apply { text = this.readText() }

        val gson = GsonBuilder().setLenient()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .create()

        val bankAccount = gson.fromJson(text, BankAccount::class.java)
        bankAccount.transactions.sortByDescending { it.date }

        return bankAccount
    }

}