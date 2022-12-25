package com.jfb.msavaliadorcredito.application.exception

class ErrorComunicacaoMSException(
  override val message: String,
  val errorCode: Int
): Exception()