package com.jfb.msclientes.application.converter

import com.jfb.msclientes.application.response.ClienteResponse
import com.jfb.msclientes.domain.Cliente

fun Cliente.toResponse():ClienteResponse
  = ClienteResponse(
    id = this.id,
    cpf = this.cpf,
    nome = this.nome,
    idade = this.idade
  )