package com.astutify.bankkata

import java.util.*

class DepositTransaction(
    override val amount: Int,
    override val date: Date
) : Transaction {

    override fun toString(): String {
        return date.day.toString() + date.month.toString() + date.year.toString() + " || " + amount
    }
}
