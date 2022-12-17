package com.jfb.msclientes.application.service

import com.jfb.msclientes.domain.Cliente
import com.jfb.msclientes.infra.repository.ClienteRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Service
class ClienteService(
  private val repository: ClienteRepository
) {

  @Transactional
  fun salvar(
    cliente: Cliente
  ): Cliente {
    return repository.save(cliente)
  }

  fun findByCpf(
    cpf: String
  ): Optional<Cliente> {
    return repository.findByCpf(cpf)
  }

}