package com.nubank.nuclientes.service;

import com.nubank.nuclientes.dto.ClienteDTO;
import com.nubank.nuclientes.entity.Cliente;
import com.nubank.nuclientes.entity.Contato;
import com.nubank.nuclientes.mapper.ClienteMapper;
import com.nubank.nuclientes.repository.ClienteRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.nio.file.ProviderNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;


    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }


    public List<ClienteDTO> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();

        for (Cliente cliente : clientes) {
            for (Contato contato : cliente.getContatos()) {
                contato.setCliente(cliente);
            }
        }

        return clientes.stream()
                .map(clienteMapper::toDTOComContatos)
                .collect(Collectors.toList());
    }

    public ClienteDTO salvar(ClienteDTO dto) {
        Cliente cliente = clienteMapper.toEntity(dto);
        Cliente salvo = clienteRepository.save(cliente);
        return clienteMapper.toDTO(salvo);
    }

    public ClienteDTO buscarID( Long id ) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
        return clienteMapper.toDTO(cliente);
    }


    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
