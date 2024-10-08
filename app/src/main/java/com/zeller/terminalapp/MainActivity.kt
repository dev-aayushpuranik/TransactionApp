package com.zeller.terminalapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zeller.terminalapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var transactionAdapter: TransactionAdapter
    private var transactionsData: ArrayList<Transactions> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.depositButton.setOnClickListener(this)
        binding.withdrawButton.setOnClickListener(this)
        setContentView(binding.root)

        binding.transactionRV.layoutManager = LinearLayoutManager(this)
        transactionAdapter = TransactionAdapter(this, transactionsData)
        binding.transactionRV.adapter = transactionAdapter
    }

    override fun onClick(view: View?) {
        var amt = 0f
        if (view?.id == R.id.withdrawButton) {
            val balance = MainViewModel.balance
            if (!binding.amountInput.text.isNullOrEmpty()) {
                amt = binding.amountInput.text.toString().toFloat()
                if (balance >= amt) {
                    MainViewModel.balance -= amt
                    binding.balance.text = MainViewModel.balance.toString()
                    MainViewModel.transactions.addTransaction(Transactions(isDeposit = false, amount = amt))
                    transactionsData.add(0, Transactions(isDeposit = false, amount = amt))
                    transactionAdapter.updateData(transactionsData)
                } else {
                    Toast.makeText(this, "Not enough balance", Toast.LENGTH_LONG).show()
                }
            }

        } else if (view?.id == R.id.depositButton) {
            if (!binding.amountInput.text.isNullOrEmpty()) {
                amt = binding.amountInput.text.toString().toFloat()
                MainViewModel.balance += amt
                binding.balance.text = MainViewModel.balance.toString()
                MainViewModel.transactions.addTransaction(Transactions(isDeposit = true, amount = amt))
                transactionsData.add(0, Transactions(isDeposit = true, amount = amt))
                transactionAdapter.updateData(transactionsData)
            }
        }
    }
}