package com.jfb.msavaliadorcredito.application.domain

import java.math.BigDecimal

data class CartaoAprovado(
  val cartao: String,
  val bandeira: String,
  val limiteAprovado: BigDecimal
)