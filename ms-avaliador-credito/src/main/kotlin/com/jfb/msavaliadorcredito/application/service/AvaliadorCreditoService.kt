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
import java.math.BigDecimal
import java.util.stream.Collectors

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
    cpf: String,
    renda: Long
  ): RetornoAvaliacaoCliente {
    try {
      val dadosClienteResponse: ResponseEntity<DadosCliente> = clientesClient.findByCpf(cpf)
      val cartoesRendaAtehResponse = cartaoClient.findCartoesRendaAteh(renda)

      val cartoes: List<Cartao>? = cartoesRendaAtehResponse.body

      val listaCartoesAprivados = cartoes?.stream()?.map {
        val dadosCliente: DadosCliente? = dadosClienteResponse.body

        val limiteBasico: BigDecimal = it.limiteBasico
        val idadeBD: BigDecimal = BigDecimal.valueOf(dadosCliente?.idade?.toLong()!!)

        val fator = idadeBD.divide(BigDecimal.valueOf(10))
        val limiteAprovado = fator.multiply(limiteBasico)

        return@map CartaoAprovado(
          cartao = it.nome,
          bandeira = it.bandeira,
          limiteAprovado = limiteAprovado
        )

      }?.collect(Collectors.toList())

      return RetornoAvaliacaoCliente(listaCartoesAprivados)

    } catch (e: FeignClientException) {
      val status = e.status()
      if (HttpStatus.NOT_FOUND.value() == status) {
        throw DadosClienteNotFoundException(Errors.AC0001.message, Errors.AC0001.code)
      }
      throw ErrorComunicacaoMSException("ErrorComunicacaoMSException.", status)
    }
  }

}
