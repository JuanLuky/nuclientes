package com.nubank.nuclientes.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ContatoDTO {
    private Long id;

    @NotBlank(message = "O campo 'email' é obrigatório.")
    private String email;

    @NotBlank(message = "O campo 'telefone' é obrigatório.")
    @Size(min = 8, max = 15, message = "O telefone deve ter entre 8 e 15 caracteres.")
    private String telefone;

    private Long clienteId; // ID do cliente ao qual o contato pertence

}
