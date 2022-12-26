package com.jfb.mscartoes

import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableRabbit
@EnableEurekaClient
@SpringBootApplication
class MsCartoesApplication

fun main(args: Array<String>) {
	runApplication<MsCartoesApplication>(*args)
}
