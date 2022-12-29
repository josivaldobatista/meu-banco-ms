package com.jfb.msavaliadorcredito.adapter.`in`.web.controller

import com.jfb.msavaliadorcredito.adapter.`in`.web.AvaliadorCreditoApi
import com.jfb.msavaliadorcredito.application.domain.*
import com.jfb.msavaliadorcredito.application.exception.ErrorSolicitacaoCartaoException
import com.jfb.msavaliadorcredito.application.service.AvaliadorCreditoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AvaliadorCreditoController(
  private val avaliadorCreditoService: AvaliadorCreditoService
): AvaliadorCreditoApi {

  override fun status(): String {
    return "Status OK ms-avaliador-credito"
  }

  override fun consultarSituacaoCliente(
    cpf: String
  ): ResponseEntity<SituacaoCliente> {
    val situacaoCliente: SituacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf)
    return ResponseEntity.ok(situacaoCliente)
  }

  override fun realizarAvaliacao(
    @RequestBody dadosAvaliacao: DadosAvaliacao
  ): ResponseEntity<RetornoAvaliacaoCliente> {
    val retornoAvaliacaoCliente = avaliadorCreditoService.realizarAvaliacao(dadosAvaliacao.cpf, dadosAvaliacao.renda)
    return ResponseEntity.ok(retornoAvaliacaoCliente)
  }

  override fun solicitarCartao(
    @RequestBody dadosSolicitacaoEmissaoCartao: DadosSolicitacaoEmissaoCartao
  ): ResponseEntity<Any> {
    return try {
      val solicitarEmissaoCartao = avaliadorCreditoService.solicitarEmissaoCartao(dadosSolicitacaoEmissaoCartao)
      ResponseEntity.ok(solicitarEmissaoCartao)
    } catch (e: ErrorSolicitacaoCartaoException) {
      ResponseEntity.internalServerError().body(e.message)
    }
  }
}