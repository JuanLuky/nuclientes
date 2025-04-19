package com.nubank.nuclientes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class ClienteDTO {
    private Long id;

    @NotBlank(message = "O campo 'Nome' é obrigatório.")
    @Size(min = 3, max = 200, message = "O nome deve ter no minimo 3.")
    private String nome;

    private List<ContatoDTO> contatos; // Lista de contatos associados
}