package com.jfb.msavaliadorcredito.adapter.`in`.web.controller

import com.jfb.msavaliadorcredito.adapter.`in`.web.AvaliadorCreditoApi
import com.jfb.msavaliadorcredito.application.domain.SituacaoCliente
import com.jfb.msavaliadorcredito.application.service.AvaliadorCreditoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class AvaliadorCreditoController(
  private val avaliadorCreditoService: AvaliadorCreditoService
): AvaliadorCreditoApi {

  override fun status(): String {
    return "Status OK ms-avaliador-credito"
  }

  override fun consultaSituacaoCliente(
    cpf: String
  ): ResponseEntity<SituacaoCliente> {
    val situacaoCliente: SituacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf)
    return ResponseEntity.ok(situacaoCliente)
  }
}