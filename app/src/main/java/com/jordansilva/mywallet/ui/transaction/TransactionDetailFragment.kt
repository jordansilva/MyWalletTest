package com.jordansilva.mywallet.ui.transaction

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.jordansilva.mywallet.R
import com.jordansilva.mywallet.model.BankTransactionView
import com.jordansilva.mywallet.util.asString
import com.jordansilva.mywallet.util.money
import kotlinx.android.synthetic.main.activity_transaction_detail.view.*


class TransactionDetailFragment : DialogFragment() {

    companion object {

        fun newInstance(transaction: BankTransactionView): TransactionDetailFragment {
            val frag = TransactionDetailFragment()
            val args = Bundle()
            args.putParcelable("TRANSACTION", transaction)
            frag.arguments = args
            return frag
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.activity_transaction_detail, null)

        val dialog = Dialog(context!!)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(view)
        dialog.setCancelable(true)
        dialog.setCanceledOnTouchOutside(true)

        val transactionView = arguments?.getParcelable<BankTransactionView>("TRANSACTION")
        initUi(view, transactionView)

        return dialog
    }

    private fun initUi(view: View, transactionView: BankTransactionView?) {
        transactionView?.let {
            view.textDate.text = it.date.asString("dd MMM yyyy HH:mm")
            view.textAmount.text = it.amount.money()
            view.textOtherAccount.text = it.otherAccount

            view.textIdentifier.text = it.id
            view.textDescription.text = it.description
        }
    }

    override fun onStart() {
        if (dialog == null) {
            return
        }

        dialog.window!!.setWindowAnimations(
            R.style.dialog_animation_fade
        )

        super.onStart()
    }

}
