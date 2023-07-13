package com.nashtech.nashtech.datasource.mock

import org.assertj.core.api.Assertions.assertThat

import org.junit.jupiter.api.Test

internal class MockDataSourceTest{

    private val mockDataSource = MockDataSource()

    @Test
    fun should_provide_a_collection_of_Banks(){
        //given

        //when
        val bank = mockDataSource.retrieveBanks()

        //then
        assertThat(bank.size).isGreaterThanOrEqualTo(3)
    }

    @Test
    fun shouldProvideSomeMockData(){
        val bank = mockDataSource.retrieveBanks()
        assertThat(bank).allMatch{it.accountNumber.isNotEmpty()}
        assertThat(bank).allMatch{it.trust != 0.0}
    }

}