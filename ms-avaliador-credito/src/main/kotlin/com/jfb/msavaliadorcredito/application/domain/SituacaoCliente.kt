package com.jfb.msavaliadorcredito.application.domain

data class SituacaoCliente(
  val cliente: DadosCliente?,
  val cartoes: List<CartaoCliente>?
)