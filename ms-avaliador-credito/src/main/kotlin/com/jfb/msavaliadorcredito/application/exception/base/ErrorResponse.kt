package com.jfb.msavaliadorcredito.application.exception.base

import org.springframework.http.HttpStatus

data class ErrorResponse(
  var status: Int,
  var message: String,
  var internalCode: String,
  var errors: List<FieldErrorResponse>?
)