package com.nashtech.nashtech.datasource

import com.nashtech.nashtech.model.Bank

interface BankDataSource {

    fun retrieveBank(): Collection<Bank>
}