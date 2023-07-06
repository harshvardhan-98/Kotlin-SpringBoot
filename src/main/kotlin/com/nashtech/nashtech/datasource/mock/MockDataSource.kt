package com.nashtech.nashtech.datasource.mock

import com.nashtech.nashtech.datasource.BankDataSource
import com.nashtech.nashtech.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockDataSource: BankDataSource {

    val bank = listOf(Bank("",0.0,1))

    override fun getBanks(): Collection<Bank> = bank

}