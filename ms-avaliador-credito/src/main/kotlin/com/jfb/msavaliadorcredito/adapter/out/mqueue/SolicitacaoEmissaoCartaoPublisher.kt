package com.jfb.msavaliadorcredito.adapter.out.mqueue

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jfb.msavaliadorcredito.application.domain.DadosSolicitacaoEmissaoCartao
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class SolicitacaoEmissaoCartaoPublisher(
  val rabbitTemplate: RabbitTemplate,
  val queueEmissaoCartao: Queue
) {

  fun solicitarCartao(
    dados: DadosSolicitacaoEmissaoCartao
  ) {
    val json = corvertIntoJson(dados)
    if (json != null) {
      rabbitTemplate.convertAndSend(queueEmissaoCartao.name, json)
    }
  }

  fun corvertIntoJson(
    dados: DadosSolicitacaoEmissaoCartao
  ): String? {
    val mapper = jacksonObjectMapper()
    val writeValueAsString = mapper.writeValueAsString(dados)
    return writeValueAsString
  }
}