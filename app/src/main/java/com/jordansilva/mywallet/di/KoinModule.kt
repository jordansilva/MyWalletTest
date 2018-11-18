package com.jordansilva.mywallet.di

import com.jordansilva.mywallet.data.repository.BankAccountDataRepository
import com.jordansilva.mywallet.domain.interactor.account.GetAccountWithTransactionsUseCase
import com.jordansilva.mywallet.domain.model.BankAccount
import com.jordansilva.mywallet.domain.repository.BankAccountRepository
import com.jordansilva.mywallet.mapper.BankAccountMapperView
import com.jordansilva.mywallet.mapper.MapperView
import com.jordansilva.mywallet.model.BankAccountView
import com.jordansilva.mywallet.ui.bank.BankAccountViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

object KoinModule {

    val ViewModule = module {
        //POI details and POIs list viewModel injection
        viewModel { BankAccountViewModel(get(), get("bankAccountViewMapper")) }

        //Mappers
        factory("bankAccountViewMapper") { BankAccountMapperView() as MapperView<BankAccount, BankAccountView> }
    }

    val UseCaseModule = module {
        factory { GetAccountWithTransactionsUseCase(get()) }
    }

    val RepositoryModule = module {
       //Repositories
        factory { BankAccountDataRepository(androidApplication().assets) } bind BankAccountRepository::class
    }

}