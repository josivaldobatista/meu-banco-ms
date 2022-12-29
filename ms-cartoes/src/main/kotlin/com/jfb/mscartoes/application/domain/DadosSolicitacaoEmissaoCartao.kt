package com.jfb.mscartoes.application.domain

import java.math.BigDecimal

data class DadosSolicitacaoEmissaoCartao(
  val idCartao: Long,
  val cpf: String,
  val endereco: String,
  val limiteLiberado: Long
)