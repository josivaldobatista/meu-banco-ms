package com.jfb.mscartoes.application.service

import com.jfb.mscartoes.adapter.out.repository.CartaoRepository
import com.jfb.mscartoes.application.domain.Cartao
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@Service
class CartaoService(
  private val repository: CartaoRepository
) {

  @Transactional
  fun save(
    cartao: Cartao
  ): Cartao {
    return repository.save(cartao)
  }

  fun getCartoesRendaMenorIgual(
    renda: Long
  ): List<Cartao> {
    val rendaBigDecimal = BigDecimal.valueOf(renda)
    return repository.findByRendaLessThanEqual(rendaBigDecimal)
  }
}