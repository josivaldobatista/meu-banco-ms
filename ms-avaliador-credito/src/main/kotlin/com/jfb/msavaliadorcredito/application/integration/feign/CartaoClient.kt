package com.jfb.msavaliadorcredito.application.integration.feign

import com.jfb.msavaliadorcredito.application.domain.Cartao
import com.jfb.msavaliadorcredito.application.domain.CartaoCliente
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import javax.validation.Valid

@FeignClient(
  value = "mscartoes",
  path = "/cartao"
)
interface CartaoClient {

  @GetMapping(params = ["cpf"])
  @ResponseStatus(HttpStatus.OK)
  fun findCartoesByCliente(
    @RequestParam("cpf") cpf: String
  ): ResponseEntity<List<CartaoCliente>>

  @GetMapping(params = ["renda"])
  fun findCartoesRendaAteh(
    @Valid @RequestParam("renda") renda: Long
  ): ResponseEntity<List<Cartao>>
}