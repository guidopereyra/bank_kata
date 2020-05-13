package com.astutify.bankkata.unitest

import com.astutify.bankkata.*
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import java.util.*

class AccountServiceShould {

    private lateinit var accountRepository: AccountRepository
    private lateinit var dateProvider: DateProvider
    private lateinit var printer: Printer
    private lateinit var account: AccountService
    private lateinit var actualDate: Date

    @Before
    fun setup() {
        accountRepository = mock()
        dateProvider = mock()
        printer = mock()
        account = AccountService(accountRepository, dateProvider, printer)
        actualDate = Date(2020, 5, 6)
        whenever(dateProvider.getCurrentDate()).thenReturn(actualDate)
    }

    @Test
    fun `deposit ammount`() {
        val expectedResult = DepositTransaction(10, actualDate)

        account.deposit(10)

        verify(accountRepository).save(expectedResult)
    }

    @Test
    fun `withdraw ammount`() {
        val expectedResult = WitdrawTransaction(1000, actualDate)

        account.witdraw(1000)

        verify(accountRepository).save(expectedResult)
    }

    @Test
    fun `should print blank statement`() {
        account.printStatement()

        verify(printer).print("date || credit || debit || balance")
    }

    @Test
    fun `should print statement`() {
        account.deposit(1000)
        account.printStatement()

        verify(printer).print("date || credit || debit || balance \n" +
                "04/05/2020 || 1000 || || 1000" )
    }
}