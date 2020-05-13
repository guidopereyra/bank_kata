package com.astutify.bankkata

class AccountRepositoryImpl : AccountRepository{

    override val transactions: MutableList<Transaction> = mutableListOf()

    override fun save(transaction: Transaction) {
        transactions.add(transaction)
    }
}