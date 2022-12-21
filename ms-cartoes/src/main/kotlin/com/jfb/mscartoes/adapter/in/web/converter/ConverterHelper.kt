package com.jfb.mscartoes.adapter.`in`.web.converter

import com.jfb.mscartoes.adapter.`in`.web.request.CartaoRequest
import com.jfb.mscartoes.application.domain.Cartao

fun CartaoRequest.toModel() = Cartao(
  nome = nome,
  bandeira = bandeira,
  renda = renda,
  limiteBasico = limiteBasico
)