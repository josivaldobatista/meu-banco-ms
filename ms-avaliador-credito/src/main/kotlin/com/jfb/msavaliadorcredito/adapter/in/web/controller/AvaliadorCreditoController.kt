package com.jfb.msavaliadorcredito.adapter.`in`.web.controller

import com.jfb.msavaliadorcredito.adapter.`in`.web.AvaliadorCreditoApi
import org.springframework.web.bind.annotation.RestController

@RestController
class AvaliadorCreditoController(): AvaliadorCreditoApi {

  override fun status(): String {
    return "Status OK ms-avaliador-credito"
  }
}