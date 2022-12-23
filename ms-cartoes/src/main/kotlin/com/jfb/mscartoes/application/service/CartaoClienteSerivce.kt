package com.jfb.mscartoes.application.service

import com.jfb.mscartoes.adapter.out.repository.CartaoClienteRepository
import com.jfb.mscartoes.application.domain.CartaoCliente
import org.springframework.stereotype.Service

@Service
class CartaoClienteSerivce(
  private val cartaoClienteRepository: CartaoClienteRepository
) {

  fun listCartaoByCpf(
    cpf: String
  ): List<CartaoCliente> {
    return cartaoClienteRepository.findByCpf(cpf)
  }
}