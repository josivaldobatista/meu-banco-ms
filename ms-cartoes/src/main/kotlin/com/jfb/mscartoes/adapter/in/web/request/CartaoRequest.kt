package com.jfb.mscartoes.adapter.`in`.web.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.jfb.mscartoes.application.domain.Bandeira
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.NotBlank

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
data class CartaoRequest(
  @field:[NotBlank] val nome: String,
  @field:[NotNull] val bandeira: Bandeira,
  @field:[NotNull DecimalMin("0.01")] val renda: BigDecimal,
  @field:[NotNull DecimalMin("0.01")] val limiteBasico: BigDecimal
)
