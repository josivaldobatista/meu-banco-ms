package com.jfb.msavaliadorcredito

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
class MsAvaliadorCreditoApplication

fun main(args: Array<String>) {
	runApplication<MsAvaliadorCreditoApplication>(*args)
}
