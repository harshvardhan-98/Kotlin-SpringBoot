package com.nashtech.nashtech.datasource.mock

import org.assertj.core.api.Assertions

import org.junit.jupiter.api.Test

internal class MockDataSourceTest{

    private val mockDataSource = MockDataSource()

    @Test
    fun should_provide_a_collection_of_Banks(){
        //given

        //when
        val bank = mockDataSource.getBanks()

        //then
        Assertions.assertThat(bank).isNotEmpty()

    }
}