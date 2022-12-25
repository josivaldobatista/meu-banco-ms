package com.jfb.msavaliadorcredito.application.exception.handler

import com.jfb.msavaliadorcredito.application.exception.DadosClienteNotFoundException
import com.jfb.msavaliadorcredito.application.exception.base.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class AvaliadorCreditoExceptionHandler {

  @ExceptionHandler(DadosClienteNotFoundException::class)
  fun notFoundExceptionDadosCliente(e: DadosClienteNotFoundException, request: WebRequest
  ): ResponseEntity<ErrorResponse> {
    val error = ErrorResponse(
      HttpStatus.NOT_FOUND.value(),
      e.message,
      e.errorCode,
      null
    )
    return ResponseEntity(error, HttpStatus.NOT_FOUND)
  }


}