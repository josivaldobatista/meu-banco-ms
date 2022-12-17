package com.jfb.msclientes.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Cliente(

  val cpf: String = "",
  val nome: String = "",
  val idade: Int? = null
) {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  val id: Long = 0
}