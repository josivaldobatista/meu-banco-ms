package com.jfb.msclientes.infra.repository

import com.jfb.msclientes.domain.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ClienteRepository: JpaRepository<Cliente, Long> {

  fun findByCpf(cpf: String): Optional<Cliente>
}