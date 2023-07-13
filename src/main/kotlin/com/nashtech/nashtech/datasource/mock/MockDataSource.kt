package com.nashtech.nashtech.datasource.mock

import com.nashtech.nashtech.datasource.BankDataSource
import com.nashtech.nashtech.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockDataSource: BankDataSource {

    val banks = mutableListOf(
        Bank("12345",3.0,1),
        Bank("23456",4.0,2),
        Bank("34567",5.0,3),
        Bank("45678",6.0,4)
    )

    override fun retrieveBanks(): Collection<Bank> = banks
    override fun retrieveBank(accNumber: String): Bank =
        banks.first { it.accountNumber == accNumber }

    override fun createBank(bank: Bank): Bank {
        if (banks.any { it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("Bank with account number ${bank.accountNumber} already exists.")
        }
        banks.add(bank)

        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val currentBank = banks.firstOrNull { it.accountNumber == bank.accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number ${bank.accountNumber}")

        banks.remove(currentBank)
        banks.add(bank)

        return bank
    }

    override fun deleteBank(accountNumber: String) {
        val currentBank = banks.firstOrNull { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")

        banks.remove(currentBank)
    }

}