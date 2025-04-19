package com.nubank.nuclientes.controller;

import com.nubank.nuclientes.dto.ClienteDTO;
import com.nubank.nuclientes.dto.ContatoDTO;
import com.nubank.nuclientes.service.ClienteService;
import com.nubank.nuclientes.service.ContatoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final ContatoService contatoService;

    public ClienteController(ClienteService clienteService, ContatoService contatoService) {
        this.clienteService = clienteService;
        this.contatoService = contatoService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClienteDTO> criarCliente(@Valid @RequestBody ClienteDTO dto) {
        return ResponseEntity.ok(clienteService.salvar(dto));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<ClienteDTO> buscarPorID(@PathVariable Long id) {
//        return ResponseEntity.ok(clienteService.buscarID(id));
//    }

    @GetMapping("/{id}/contatos")
    public ResponseEntity<List<ContatoDTO>> listarContatosPorCliente(@PathVariable Long id) {
        List<ContatoDTO> contatos = contatoService.buscarContatosPorClienteId(id);
        return ResponseEntity.ok(contatos);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
