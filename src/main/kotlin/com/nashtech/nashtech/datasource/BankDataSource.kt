package com.nashtech.nashtech.datasource

import com.nashtech.nashtech.model.Bank

interface BankDataSource {

    fun retrieveBanks(): Collection<Bank>
    fun retrieveBank(accNumber: String): Bank

    fun createBank(bank: Bank): Bank

    fun updateBank(bank: Bank): Bank

    fun deleteBank(accountNumber: String)
}