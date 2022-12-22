package com.jfb.mscartoes.adapter.`in`.web.controller

import com.jfb.mscartoes.adapter.`in`.web.CartaoApi
import com.jfb.mscartoes.adapter.`in`.web.converter.toModel
import com.jfb.mscartoes.adapter.`in`.web.converter.toResponse
import com.jfb.mscartoes.adapter.`in`.web.request.CartaoRequest
import com.jfb.mscartoes.adapter.`in`.web.response.CartaoResponse
import com.jfb.mscartoes.application.domain.Cartao
import com.jfb.mscartoes.application.service.CartaoService
import com.jfb.mscartoes.application.utils.logger
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
    cartaoRequest: CartaoRequest
  ): CartaoResponse {
    return cartaoRequest.toModel()
      .apply { cartaoService.save(this) }
      .also { logger.info("Cartao salvo: [${it}]") }
      .toResponse()
  }

  override fun findCartoesRendaAteh(
    renda: Long
  ): ResponseEntity<List<Cartao>> {
    val list: List<Cartao> = cartaoService.getCartoesRendaMenorIgual(renda)
    return ResponseEntity.ok(list)
  }
}