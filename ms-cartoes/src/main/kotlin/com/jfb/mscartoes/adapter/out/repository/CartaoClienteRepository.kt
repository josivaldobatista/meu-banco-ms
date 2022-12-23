package com.jfb.mscartoes.adapter.out.repository

import com.jfb.mscartoes.adapter.`in`.web.response.CartoesPorClienteResponse
import com.jfb.mscartoes.application.domain.CartaoCliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CartaoClienteRepository: JpaRepository<CartaoCliente, Long> {

  fun findByCpf(
    cpf: String
  ): List<CartaoCliente>
}