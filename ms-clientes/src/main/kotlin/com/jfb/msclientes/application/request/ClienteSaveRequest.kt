package com.jfb.msclientes.application.request

import com.jfb.msclientes.domain.Cliente

data class ClienteSaveRequest(
  val id: Long,
  val cpf: String,
  val nome: String,
  val idade: Int
) {

  fun toModel(): Cliente {
    return Cliente(
      id = this.id,
      cpf = this.cpf,
      nome = this.nome,
      idade = this.idade
    )
  }
}
