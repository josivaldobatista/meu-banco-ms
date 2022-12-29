package com.jfb.msavaliadorcredito.application.config

import org.springframework.amqp.core.Queue
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MQConfig {

  @Value("\${mq.queues.emissao-de-cartoes}")
  private val emissaoCartaoFila: String = ""

  @Bean
  fun queueEmissaoCartoes(): Queue {
    return Queue(emissaoCartaoFila,true)
  }
}