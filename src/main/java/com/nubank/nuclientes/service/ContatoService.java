package com.nubank.nuclientes.service;

import com.nubank.nuclientes.dto.ContatoDTO;
import com.nubank.nuclientes.entity.Cliente;
import com.nubank.nuclientes.entity.Contato;
import com.nubank.nuclientes.mapper.ContatoMapper;
import com.nubank.nuclientes.repository.ClienteRepository;
import com.nubank.nuclientes.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.nio.file.ProviderNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final ClienteRepository clienteRepository;
    private final ContatoMapper contatoMapper;

    public ContatoService(ContatoRepository contatoRepository, ClienteRepository clienteRepository, ContatoMapper contatoMapper) {
        this.contatoRepository = contatoRepository;
        this.clienteRepository = clienteRepository;
        this.contatoMapper = contatoMapper;
    }

    public ContatoDTO salvar(ContatoDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Contato contato = contatoMapper.toEntity(dto);
        contato.setCliente(cliente);

        Contato salvo = contatoRepository.save(contato);

        return contatoMapper.toDTO(salvo);
    }

    public List<ContatoDTO> listarTodos() {
        return contatoRepository.findAll()
                .stream()
                .map(contatoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ContatoDTO buscarID( Long id ) {
        Contato contato = contatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));
        return contatoMapper.toDTO(contato);
    }

    public List<ContatoDTO> buscarContatosPorClienteId(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ProviderNotFoundException("Cliente não encontrado"));

        return cliente.getContatos().stream()
                .map(contatoMapper::toDTO)
                .collect(Collectors.toList());
    }


    public void deletar(Long id) {
        contatoRepository.deleteById(id);
    }
}
