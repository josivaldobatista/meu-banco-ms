package com.jfb.msavaliadorcredito.application.domain

import java.math.BigDecimal

data class CartaoCliente(
  val nome: String,
  val bandeira: String,
  val limiteLiberado: BigDecimal
)
