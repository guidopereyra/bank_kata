package com.astutify.bankkata

interface AccountRepository {
    val transactions: List<Transaction>
    fun save(transaction: Transaction)
}
