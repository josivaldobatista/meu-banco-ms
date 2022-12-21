package com.jfb.mscartoes.adapter.`in`.web.request

import com.jfb.mscartoes.application.domain.Bandeira
import java.math.BigDecimal

data class CartaoRequest(
  val nome: String,
  val bandeira: Bandeira,
  val renda: BigDecimal,
  val limiteBasico: BigDecimal
)
