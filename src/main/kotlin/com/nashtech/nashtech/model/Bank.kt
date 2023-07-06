package com.nashtech.nashtech.model


/**
 * Represents a bank account.
 *
 * @property accountNumber The account number associated with the bank account.
 * @property trust The trust value associated with the bank account.
 * @property transactionFee The transaction fee for the bank account.
 */
data class Bank(

    val accountNumber: String,
    val trust: Double,
    val transactionFee: Int
)
