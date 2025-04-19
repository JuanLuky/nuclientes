package com.nubank.nuclientes.controller;

import com.nubank.nuclientes.dto.ContatoDTO;
import com.nubank.nuclientes.service.ContatoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContatoDTO> criarContato(@Valid @RequestBody ContatoDTO dto) {
        return ResponseEntity.ok(contatoService.salvar(dto));
    }

//    @GetMapping
//    public ResponseEntity<List<ContatoDTO>> listarContatos() {
//        return ResponseEntity.ok(contatoService.listarTodos());
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<ContatoDTO> buscarPorId(@PathVariable Long id) {
//        return ResponseEntity.ok(contatoService.buscarID(id));
//    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarContato(@PathVariable Long id) {
        contatoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
