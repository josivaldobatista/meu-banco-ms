package com.jfb.mscartoes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
class MsCartoesApplication

fun main(args: Array<String>) {
	runApplication<MsCartoesApplication>(*args)
}
