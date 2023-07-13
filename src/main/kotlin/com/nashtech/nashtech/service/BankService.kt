package com.nashtech.nashtech.service

import com.nashtech.nashtech.datasource.BankDataSource
import com.nashtech.nashtech.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: BankDataSource) {

    fun getBanks() : Collection<Bank>{
        return dataSource.retrieveBanks()
    }

    fun getBank(accNumber: String): Bank = dataSource.retrieveBank(accNumber)

    fun addBank(bank: Bank): Bank = dataSource.createBank(bank)

    fun updateBank(bank: Bank): Bank = dataSource.updateBank(bank)

    fun deleteBank(accountNumber: String): Unit = dataSource.deleteBank(accountNumber)

}