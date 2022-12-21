package com.jfb.mscartoes.adapter.`in`.web.controller

import com.jfb.mscartoes.adapter.`in`.web.CartaoApi
import com.jfb.mscartoes.adapter.`in`.web.converter.toModel
import com.jfb.mscartoes.adapter.`in`.web.request.CartaoRequest
import com.jfb.mscartoes.application.domain.Cartao
import com.jfb.mscartoes.application.service.CartaoService
import com.jfb.mscartoes.application.utils.logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CartaoController(
  val cartaoService: CartaoService
): CartaoApi {

  private val logger = logger<CartaoController>()

  override fun status(): String {
    return "Status OK ms-cartao"
  }

  override fun create(
    @RequestBody cartaoRequest: CartaoRequest
  ): ResponseEntity<Any> {
    val cartao: Cartao = cartaoRequest.toModel()
    val cartaoSave = cartaoService.save(cartao)
    logger.info("Cartao salvo: [${cartaoSave}]")
    return ResponseEntity.status(HttpStatus.CREATED).build()
  }
}