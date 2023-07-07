package com.nashtech.nashtech.datasource.mock

import com.nashtech.nashtech.datasource.BankDataSource
import com.nashtech.nashtech.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockDataSource: BankDataSource {

    val bank = listOf(
        Bank("12345",3.0,1),
        Bank("23456",4.0,2),
        Bank("34567",5.0,3),
        Bank("45678",6.0,4)
    )

    override fun retrieveBank(): Collection<Bank> = bank

}