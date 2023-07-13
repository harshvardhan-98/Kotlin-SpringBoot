package com.nashtech.nashtech

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.nashtech.nashtech")
class NashtechApplication

fun main(args: Array<String>) {
	runApplication<NashtechApplication>(*args)
}

