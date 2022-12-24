package com.jfb.msavaliadorcredito.application.service

import com.jfb.msavaliadorcredito.application.domain.CartaoCliente
import com.jfb.msavaliadorcredito.application.domain.DadosCliente
import com.jfb.msavaliadorcredito.application.domain.SituacaoCliente
import com.jfb.msavaliadorcredito.application.integration.feign.CartaoClient
import com.jfb.msavaliadorcredito.application.integration.feign.ClienteClient
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class AvaliadorCreditoService(
  private val clientesClient: ClienteClient,
  private val cartaoClient: CartaoClient
) {

  fun obterSituacaoCliente(cpf: String
  ): SituacaoCliente {
    val dadosClienteResponse: ResponseEntity<DadosCliente> = clientesClient.findByCpf(cpf)
    val cartaoResponse: ResponseEntity<List<CartaoCliente>> = cartaoClient.findCartoesByCliente(cpf)

    return SituacaoCliente(
      cliente = dadosClienteResponse.body,
      cartoes = cartaoResponse.body
    )
  }

}
