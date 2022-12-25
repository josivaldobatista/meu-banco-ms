package com.jfb.msavaliadorcredito.application.service

import com.jfb.msavaliadorcredito.application.domain.*
import com.jfb.msavaliadorcredito.application.exception.DadosClienteNotFoundException
import com.jfb.msavaliadorcredito.application.exception.ErrorComunicacaoMSException
import com.jfb.msavaliadorcredito.application.integration.feign.CartaoClient
import com.jfb.msavaliadorcredito.application.integration.feign.ClienteClient
import feign.FeignException.FeignClientException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

@Service
class AvaliadorCreditoService(
  private val clientesClient: ClienteClient,
  private val cartaoClient: CartaoClient
) {

  fun obterSituacaoCliente(cpf: String
  ): SituacaoCliente {

    try {
        val dadosClienteResponse: ResponseEntity<DadosCliente> = clientesClient.findByCpf(cpf)
        val cartaoResponse: ResponseEntity<List<CartaoCliente>> = cartaoClient.findCartoesByCliente(cpf)

        return SituacaoCliente(
          cliente = dadosClienteResponse.body,
          cartoes = cartaoResponse.body
        )
    } catch (e: FeignClientException) {
      val status = e.status()
      if (HttpStatus.NOT_FOUND.value() == status) {
        throw DadosClienteNotFoundException(Errors.AC0001.message, Errors.AC0001.code)
      }
      throw ErrorComunicacaoMSException("ErrorComunicacaoMSException.", status)
    }
  }

  fun realizarAvaliacao(
    @RequestBody dadosAvaliacao: DadosAvaliacao
  ) {

  }

}
