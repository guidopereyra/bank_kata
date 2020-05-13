package com.astutify.bankkata


class AccountService(
    private val accountRepository: AccountRepository,
    private val dateProvider: DateProvider,
    private val printer: Printer
) {

    fun deposit(amount: Int) {
        accountRepository.save(DepositTransaction(amount, dateProvider.getCurrentDate()))
    }

    fun witdraw(amount: Int) {
        accountRepository.save(WitdrawTransaction(amount, dateProvider.getCurrentDate()))
    }

    fun printStatement() {
        val header = "date || credit || debit || balance"
        var transactions = header
        accountRepository.transactions.forEach {
            transactions += "\n" + it.toString() + " || " + it.amount
        }
        printer.print(transactions)
    }
}
