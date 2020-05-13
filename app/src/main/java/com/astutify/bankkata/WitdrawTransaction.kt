package com.astutify.bankkata

import java.util.*

class WitdrawTransaction(
    override val amount: Int,
    override val date: Date
) : Transaction {

    override fun toString(): String {
        return date.day.toString() + date.month.toString() + date.year.toString() + " || || " + amount
    }

    override fun equals(other: Any?): Boolean {
        return (other as WitdrawTransaction).amount == amount && (other as WitdrawTransaction).date == date
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}
