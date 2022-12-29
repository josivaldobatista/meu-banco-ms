package com.jfb.msavaliadorcredito.application.domain

import java.math.BigDecimal

data class DadosSolicitacaoEmissaoCartao(
  val idCartao: Long,
  val cpf: String,
  val endereco: String,
  val limiteLiberado: BigDecimal
)