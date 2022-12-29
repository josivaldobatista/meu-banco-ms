package com.jfb.mscartoes.adapter.`in`.web.response

import java.math.BigDecimal

data class CartoesPorClienteResponse(
  val nome: String,
  val bandeira: String,
  val limiteLiberado: Long
)
