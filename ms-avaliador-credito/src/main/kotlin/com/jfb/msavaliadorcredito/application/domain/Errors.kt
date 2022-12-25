package com.jfb.msavaliadorcredito.application.domain

enum class Errors(
  val code: String,
  val message: String
) {
  AC0001("AC-0001", "Dados do cliente não encontrado para o CPF informado.")
}