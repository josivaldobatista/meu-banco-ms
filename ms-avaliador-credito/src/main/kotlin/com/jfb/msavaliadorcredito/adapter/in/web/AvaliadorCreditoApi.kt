package com.jfb.msavaliadorcredito.adapter.`in`.web

import com.jfb.msavaliadorcredito.application.domain.DadosAvaliacao
import com.jfb.msavaliadorcredito.application.domain.DadosSolicitacaoEmissaoCartao
import com.jfb.msavaliadorcredito.application.domain.RetornoAvaliacaoCliente
import com.jfb.msavaliadorcredito.application.domain.SituacaoCliente
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@RequestMapping("/avaliacao-credito")
interface AvaliadorCreditoApi {

  @GetMapping("/status")
  fun status(): String

  @GetMapping(value = ["/situacao-cliente"], params = ["cpf"])
  fun consultarSituacaoCliente(
    @RequestParam("cpf") cpf: String
  ): ResponseEntity<SituacaoCliente>

  @PostMapping// (value = ["/avaliacao-cliente"], params = ["cpf"])
  fun realizarAvaliacao(
    @RequestBody dadosAvaliacao: DadosAvaliacao
  ): ResponseEntity<RetornoAvaliacaoCliente>

  @PostMapping("/solicitacoes-cartoes")
  fun solicitarCartao(
    @RequestBody dadosSolicitacaoEmissaoCartao: DadosSolicitacaoEmissaoCartao
  ): ResponseEntity<Any>
}