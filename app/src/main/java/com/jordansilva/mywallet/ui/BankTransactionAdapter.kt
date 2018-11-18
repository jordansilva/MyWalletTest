package com.jordansilva.mywallet.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jordansilva.mywallet.R
import com.jordansilva.mywallet.model.BankTransactionView
import com.jordansilva.mywallet.util.OnItemClickViewListener
import com.jordansilva.mywallet.util.asString
import com.jordansilva.mywallet.util.money
import kotlinx.android.synthetic.main.row_transaction.view.*

class BankTransactionAdapter(items: List<BankTransactionView>?, mListener: OnItemClickViewListener<BankTransactionView>) :
    RecyclerView.Adapter<BankTransactionAdapter.ViewHolder>() {

    private val mOnClickListener: OnItemClickViewListener<BankTransactionView>
    private var data = listOf<BankTransactionView>()

    init {
        items?.let { data = items.sortedByDescending { i -> i.date } }
        mOnClickListener = mListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.row_transaction, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bindView(item)
        holder.itemView.setOnClickListener { view -> mOnClickListener.onClickItem(view, item) }
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(item: BankTransactionView) {
            view.textAmount.text = item.amount.money()
            view.textDescription.text = item.description
            view.textDate.text = item.date.asString("dd MMM yyyy")
            view.textOtherAccount.text = item.otherAccount
        }

    }
}