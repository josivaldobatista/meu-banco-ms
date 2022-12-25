package com.jfb.msavaliadorcredito.application.exception

import org.springframework.http.HttpStatus

class DadosClienteNotFoundException(
  override val message: String,
  val errorCode: String
): Exception()