package com.jfb.msavaliadorcredito.adapter.`in`.web

import com.jfb.msavaliadorcredito.application.domain.SituacaoCliente
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@RequestMapping("/avaliacao-credito")
interface AvaliadorCreditoApi {

  @GetMapping("/status")
  fun status(): String

  @GetMapping(value = ["/situacao-cliente"], params = ["cpf"])
  fun consultaSituacaoCliente(
    @RequestParam("cpf") cpf: String
  ): ResponseEntity<SituacaoCliente>
}