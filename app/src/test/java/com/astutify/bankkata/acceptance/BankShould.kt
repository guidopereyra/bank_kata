package com.astutify.bankkata.acceptance

import com.astutify.bankkata.AccountRepository
import com.astutify.bankkata.AccountService
import com.astutify.bankkata.DateProvider
import com.astutify.bankkata.Printer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

class BankShould {

    @Test
    fun `print statement for transactions`() {
        val printer: Printer = mock()
        val accountRepository: AccountRepository = mock()
        val dateProvider: DateProvider = mock()
        val account = AccountService(accountRepository, dateProvider, printer)
        account.deposit(1000)
        account.deposit(2000)
        account.witdraw(500)

        account.printStatement()

        verify(printer).print(
            "date || credit || debit || balance\n" +
                    "14/01/2012 || || 500.00 || 2500.00\n" +
                    "13/01/2012 || 2000.00 || || 3000.00\n" +
                    "10/01/2012 || 1000.00 || || 1000.00"
        )
    }
}