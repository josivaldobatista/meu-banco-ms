package com.jfb.msavaliadorcredito.application.domain

import java.math.BigDecimal

data class Cartao(
  val id: Long,
  val nome: String,
  val bandeira: String,
  val limiteBasico: BigDecimal
)
