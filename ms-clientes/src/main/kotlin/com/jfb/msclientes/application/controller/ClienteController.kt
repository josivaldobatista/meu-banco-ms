package com.jfb.msclientes.application.controller

import com.jfb.msclientes.application.request.ClienteSaveRequest
import com.jfb.msclientes.application.service.ClienteService
import com.jfb.msclientes.domain.Cliente
import com.jfb.msclientes.utils.logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/clientes")
class ClienteController(
  private val clienteService: ClienteService
) {

  val logger = logger<ClienteController>()

  @GetMapping
  fun status(): String {
    logger.info("Obtendo o status do microservice de clientes")
    return "Status OK ms-clientes"
  }

  @PostMapping
  fun salvar(
    @RequestBody clienteRequest: ClienteSaveRequest
  ): ResponseEntity<Cliente> {
    val cliente = clienteService.salvar(clienteRequest.toModel())

    val uri: URI = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .query("cpf={cpf}")
      .buildAndExpand(cliente.cpf).toUri()

    return ResponseEntity.created(uri).build()
  }

  @GetMapping(params = ["cpf"])
  fun findByCpf(
    @RequestParam("cpf") cpf: String
  ): ResponseEntity<Any> {
    var cliente = clienteService.findByCpf(cpf)
    if (cliente.isEmpty) {
      return ResponseEntity.notFound().build()
    }
    return ResponseEntity.ok().body(cliente)
  }
}