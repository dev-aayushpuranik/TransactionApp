package com.zeller.terminalapp

class TransactionsList {
    private val transactionsList: MutableList<Transactions> = mutableListOf()

    fun addTransaction(transactions: Transactions) {
        transactionsList.add(transactions)
    }

    fun getAllTransactions(): MutableList<Transactions> {
        return transactionsList
    }

    fun updateTransactions(transactions: MutableList<Transactions>) {
        transactionsList.clear()
        transactionsList.addAll(transactions)
    }

    fun getCount(): Int {
        return transactionsList.size
    }
    fun getItem(index:Int) : Transactions {
        return transactionsList.get(index)
    }
}