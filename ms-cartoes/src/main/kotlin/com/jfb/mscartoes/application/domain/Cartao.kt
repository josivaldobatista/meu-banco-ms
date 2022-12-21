package com.jfb.mscartoes.application.domain

import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
data class Cartao(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null,
  val clientId: String? = UUID.randomUUID().toString(),
  val nome: String = "",
  @Enumerated(EnumType.STRING)
  val bandeira: Bandeira? = null,
  val renda: BigDecimal? = null,
  val limiteBasico: BigDecimal? = null
)