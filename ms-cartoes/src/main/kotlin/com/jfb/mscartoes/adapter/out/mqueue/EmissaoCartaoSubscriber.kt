package com.jfb.mscartoes.adapter.out.mqueue

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class EmissaoCartaoSubscriber {

  @RabbitListener(
    queues = ["\${mq.queues.emissao-de-cartoes}"]
  )
  fun receberSolicitacaoEmissao(
    @Payload payload: String
  ) {
    println(payload)
  }
}