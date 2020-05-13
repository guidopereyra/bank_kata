package com.astutify.bankkata.unitest

import com.astutify.bankkata.AccountRepository
import com.astutify.bankkata.AccountRepositoryImpl
import com.astutify.bankkata.DepositTransaction
import com.astutify.bankkata.WitdrawTransaction
import org.junit.Test
import java.util.*

class AccountRepositoryShould {

    @Test
    fun `save ammount on repository`() {
        val accountRepository: AccountRepository = AccountRepositoryImpl()
        val expectedTransaction = DepositTransaction(10, Date(2020, 5, 6))

        accountRepository.save(expectedTransaction)

        assert(accountRepository.transactions[0] == expectedTransaction)
    }

    @Test
    fun `remove ammount from repository`(){
        val accountRepository: AccountRepository = AccountRepositoryImpl()
        val expectedTransaction = WitdrawTransaction(10, Date(2020, 5, 6))

        accountRepository.save(expectedTransaction)

        assert(accountRepository.transactions[0] == expectedTransaction)
    }
}