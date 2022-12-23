package com.jfb.mscartoes.application.domain

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class CartaoCliente(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,
  val cpf: String,
  @ManyToOne()
  @JoinColumn(name = "id_cartao")
  val cartao: Cartao,
  val limiteAprovado: BigDecimal
)