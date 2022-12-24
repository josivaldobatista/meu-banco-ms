package com.jfb.msavaliadorcredito.application.integration.feign

import com.jfb.msavaliadorcredito.application.domain.DadosCliente
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
  value = "msclientes",
  path = "/clientes"
)
interface ClienteClient {

  @GetMapping(params = ["cpf"])
  fun findByCpf(
    @RequestParam("cpf") cpf: String
  ): ResponseEntity<DadosCliente>

}