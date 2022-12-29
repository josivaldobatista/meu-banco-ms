package com.jfb.msavaliadorcredito

import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableRabbit
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
class MsAvaliadorCreditoApplication

fun main(args: Array<String>) {
	runApplication<MsAvaliadorCreditoApplication>(*args)
}
