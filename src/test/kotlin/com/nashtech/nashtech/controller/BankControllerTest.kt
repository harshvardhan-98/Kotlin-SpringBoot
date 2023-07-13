package com.nashtech.nashtech.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.nashtech.nashtech.model.Bank
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
) {

    @Test
    fun shouldReturnAllBanks(){
        mockMvc.get("/api/banks")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$[0].accountNumber"){
                    value("12345")
                }
            }
    }

    @Test
    fun returnBankWithGivenAccNo(){
        val accountNumber = 12345
        mockMvc.get("/api/banks/$accountNumber")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.transactionFee"){value("1")}
            }
    }

    @Test
    fun `should add the new bank`() {
        // given
        val newBank = Bank("acc123", 31.415, 2)

        // when
        val performPost = mockMvc.post("/api/banks") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(newBank)
        }

        // then
        performPost
            .andDo { print() }
            .andExpect {
                status { isCreated() }
                content {
                    contentType(MediaType.APPLICATION_JSON)
                    json(objectMapper.writeValueAsString(newBank))
                }
            }

        mockMvc.get("/api/banks/${newBank.accountNumber}")
            .andExpect { content { json(objectMapper.writeValueAsString(newBank)) } }
    }
}