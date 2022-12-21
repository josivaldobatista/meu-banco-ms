package com.jfb.mscartoes.adapter.out

import com.jfb.mscartoes.application.domain.Cartao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
interface CartaoRepository: JpaRepository<Cartao, Long> {

  fun findByRendaLessThanEqual(renda: BigDecimal): List<Cartao>
}