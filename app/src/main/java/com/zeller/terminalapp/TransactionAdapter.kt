package com.zeller.terminalapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransactionAdapter(
    val context: Context,
    var transactions: ArrayList<Transactions>
): RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        return TransactionViewHolder(LayoutInflater.from(context).inflate(R.layout.transaction_row, parent, false))
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = if(transactions.get(position).isDeposit) { "- Deposit" } else "- WithDrawal"
        holder.transactionRow.text = " ${transactions.get(position).amount} $transaction"
    }


    override fun getItemCount(): Int {
        return transactions.size
    }

    fun updateData(transactionsData: ArrayList<Transactions>) {
        this.transactions = transactionsData
        notifyDataSetChanged()
    }

    class TransactionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        lateinit var transactionRow: TextView

        init {
            transactionRow = itemView.findViewById(R.id.transaction_row)
        }
    }
}