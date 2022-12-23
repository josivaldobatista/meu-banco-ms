package com.jfb.msavaliadorcredito.adapter.`in`.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/avaliacoes-credito")
interface AvaliadorCreditoApi {

  @GetMapping("/status")
  fun status(): String
}