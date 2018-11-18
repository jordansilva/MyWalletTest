package com.jordansilva.mywallet.ui

import androidx.lifecycle.MutableLiveData
import com.jordansilva.mywallet.domain.interactor.account.GetAccountWithTransactionsUseCase
import com.jordansilva.mywallet.domain.model.BankAccount
import com.jordansilva.mywallet.mapper.MapperView
import com.jordansilva.mywallet.model.BankAccountView

class BankAccountViewModel(private val getPOIUseCase: GetAccountWithTransactionsUseCase,
                   private val mapper: MapperView<BankAccount, BankAccountView>) : BaseViewModel() {

    val bankAccount: MutableLiveData<BankAccountView> = MutableLiveData()

    fun getBankAccount() {
        val result = getPOIUseCase.execute()
        val bankAccountView = mapper.mapFromDomain(result)

        bankAccount.postValue(bankAccountView)
    }
}