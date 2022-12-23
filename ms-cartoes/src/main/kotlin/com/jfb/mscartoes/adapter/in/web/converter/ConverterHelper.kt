package com.jfb.mscartoes.adapter.`in`.web.converter

import com.jfb.mscartoes.adapter.`in`.web.request.CartaoRequest
import com.jfb.mscartoes.adapter.`in`.web.response.CartaoResponse
import com.jfb.mscartoes.adapter.`in`.web.response.CartoesPorClienteResponse
import com.jfb.mscartoes.adapter.`in`.web.response.CartoesPorClienteResponses
import com.jfb.mscartoes.application.domain.Cartao
import com.jfb.mscartoes.application.domain.CartaoCliente

fun CartaoRequest.toModel() = Cartao(
  nome = nome,
  bandeira = bandeira,
  renda = renda,
  limiteBasico = limiteBasico
)

fun Cartao.toResponse(): CartaoResponse =
  CartaoResponse(clientId = this.clientId)

fun List<CartaoCliente>.toResponse() = CartoesPorClienteResponses(
  cartoesCliente = this.map {
    it.toResponse() }
)

fun CartaoCliente.toResponse(): CartoesPorClienteResponse =
  CartoesPorClienteResponse(
    nome = this.cartao.nome,
    bandeira = this.cartao.bandeira.toString(),
    limiteLiberado = this.limiteAprovado
  )