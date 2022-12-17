package com.jfb.msclientes.application.request

import com.jfb.msclientes.domain.Cliente

data class ClienteSaveRequest(
  val cpf: String,
  val nome: String,
  val idade: Int
) {

  fun toModel(): Cliente {
    return Cliente(
      cpf, nome, idade
    )
  }
}
