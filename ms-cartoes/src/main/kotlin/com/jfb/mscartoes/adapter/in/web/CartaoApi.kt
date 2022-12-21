package com.jfb.mscartoes.adapter.`in`.web

import com.jfb.mscartoes.adapter.`in`.web.request.CartaoRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/cartao")
interface CartaoApi {

  @GetMapping("/status")
  fun status(): String

  @PostMapping
  fun create(
    @RequestBody cartaoRequest: CartaoRequest
  ): ResponseEntity<Any>
}