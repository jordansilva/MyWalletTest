package com.jordansilva.mywallet

import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.jordansilva.mywallet.model.BankAccountView
import com.jordansilva.mywallet.model.BankTransactionView
import com.jordansilva.mywallet.ui.BankAccountViewModel
import com.jordansilva.mywallet.ui.BankTransactionAdapter
import com.jordansilva.mywallet.util.OnItemClickViewListener
import com.jordansilva.mywallet.util.drawableLeft
import com.jordansilva.mywallet.util.money
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


//    Please use the attached transactions.json file to create both a master and detail screen for the transaction list view.
//    • Make sure that for every transaction you show the balance before and after the transaction was made.
//    • Outgoing transactions have a negative amount and similarly incoming transactions have a positive amount.
//    • Order the transactions based on date.
//    • You can simply include the transactions.json as a resource in the project.
class MainActivity : AppCompatActivity(), OnItemClickViewListener<BankTransactionView> {

    private val viewModel by viewModel<BankAccountViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        viewModel.bankAccount.observe(this, Observer { loadUI(it) })
        viewModel.getBankAccount()
    }

    private fun loadUI(account: BankAccountView) {
        textAccount.text = account.name
        textBalance.text = account.balance.money()
        textRecentTransactions.drawableLeft = R.drawable.ic_credit_card_black_24dp

        val itemDecor = DividerItemDecoration(this@MainActivity, HORIZONTAL)
        val adapter = BankTransactionAdapter(account.transactions, this@MainActivity)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(itemDecor)
    }

    override fun onClickItem(view: View, item: BankTransactionView) {
    }

}
