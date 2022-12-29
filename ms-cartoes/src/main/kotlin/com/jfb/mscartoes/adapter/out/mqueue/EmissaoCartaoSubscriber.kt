package com.jfb.mscartoes.adapter.out.mqueue

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.jfb.mscartoes.adapter.out.repository.CartaoClienteRepository
import com.jfb.mscartoes.adapter.out.repository.CartaoRepository
import com.jfb.mscartoes.application.domain.CartaoCliente
import com.jfb.mscartoes.application.domain.DadosSolicitacaoEmissaoCartao
import com.jfb.mscartoes.application.utils.logger
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class EmissaoCartaoSubscriber(
  private val cartaoRepository: CartaoRepository,
  private val clienteCartaoRepository: CartaoClienteRepository
) {

  val logger = logger<EmissaoCartaoSubscriber>()

  @RabbitListener(
    queues = ["\${mq.queues.emissao-de-cartoes}"]
  )
  fun receberSolicitacaoEmissao(
    @Payload payload: String
  ) {
    try {
        val mapper = jacksonObjectMapper()
//        val dados: DadosSolicitacaoEmissaoCartao =  mapper.readValue(payload, DadosSolicitacaoEmissaoCartao::class.java)
      logger.info("Iniciando processo de salvar cartão do cliente.")
        val dados: DadosSolicitacaoEmissaoCartao =  mapper.readValue(payload)
        val cartao = cartaoRepository.findById(dados.idCartao).orElseThrow()
        val cartaoCliente = CartaoCliente(
          cartao = cartao,
          cpf = dados.cpf,
          limiteLiberado = dados.limiteLiberado,
          id = dados.idCartao
      )
      clienteCartaoRepository.save(cartaoCliente)
      logger.info("Cartão cliente salvo: $cartaoCliente")
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }
}