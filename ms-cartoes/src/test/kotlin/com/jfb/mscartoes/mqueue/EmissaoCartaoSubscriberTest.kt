package com.jfb.mscartoes.mqueue

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.jfb.mscartoes.adapter.out.mqueue.EmissaoCartaoSubscriber
import com.jfb.mscartoes.adapter.out.repository.CartaoClienteRepository
import com.jfb.mscartoes.adapter.out.repository.CartaoRepository
import com.jfb.mscartoes.application.domain.Bandeira
import com.jfb.mscartoes.application.domain.Cartao
import com.jfb.mscartoes.application.domain.CartaoCliente
import com.jfb.mscartoes.application.domain.DadosSolicitacaoEmissaoCartao
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@ExtendWith(MockitoExtension::class)
class EmissaoCartaoSubscriberTest {

	@Mock
	private lateinit var emissaoCartaoSubscriber: EmissaoCartaoSubscriber

	@Mock
	private lateinit var cartaoRepository: CartaoRepository

	@Mock
	private lateinit var clienteCartaoRepository: CartaoClienteRepository

	@Test
	fun `deve testar a conversaao`() {

	}

	@Test
	fun whenDeserializeMovie_thenSuccess() {
		val mapper = jacksonObjectMapper()
		val cartao = Cartao(
			1,
			"0a3aac98-98c7-47fb-b094-3757df707d8a",
			"Cartão de crédito ITI",
			Bandeira.VISA,

			)
		val json = """{"id":1,"clientId":"0a3aac98-98c7-47fb-b094-3757df707d77","nome":"Cartão de crédito TESTE", "bandeira": "VISA"}"""
		val cartao2: Cartao = mapper.readValue(json)

		assertEquals(cartao2.nome, "Cartão de crédito TESTE")

	}

	@Test
	fun `deve deserializar json em ClienteCartao`() {
		val mapper = jacksonObjectMapper()
//		val payload = """{"cartao": {"id":1,"clientId":"0a3aac98-98c7-47fb-b094-3757df707d77","nome":"Cartão de crédito TESTE", "bandeira": "VISA", "renda": "5000", "limiteBasico": "5000"}, "cpf": "12345678989", "limiteLiberado": 16000, "id": 1}"""
		val payload = """{"idCartao": 1, "cpf": "12345678989", "endereco": "Rua Qualquer 789", "limiteLiberado": 16000}"""

		val dados: DadosSolicitacaoEmissaoCartao = mapper.readValue(payload)

		emissaoCartaoSubscriber.receberSolicitacaoEmissao(payload)

		assertEquals(dados.idCartao, 1)
		assertEquals(dados.cpf, "12345678989")
		assertEquals(dados.endereco, "Rua Qualquer 789")
		assertEquals(dados.limiteLiberado, 16000)

	}

}
