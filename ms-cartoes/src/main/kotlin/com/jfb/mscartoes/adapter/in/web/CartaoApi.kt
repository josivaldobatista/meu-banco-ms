package com.jfb.mscartoes.adapter.`in`.web

import com.jfb.mscartoes.adapter.`in`.web.request.CartaoRequest
import com.jfb.mscartoes.adapter.`in`.web.response.CartaoResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import javax.validation.Valid

@RequestMapping("/cartao")
interface CartaoApi {

  @GetMapping("/status")
  fun status(): String

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  fun create(
    @Valid @RequestBody cartaoRequest: CartaoRequest
  ): CartaoResponse
}