package com.nubank.nuclientes.mapper;

import com.nubank.nuclientes.dto.ClienteDTO;
import com.nubank.nuclientes.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ContatoMapper.class})
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO toDTO(Cliente cliente);

    Cliente toEntity(ClienteDTO dto);

    @Mapping(target = "contatos", source = "contatos", qualifiedByName = "toContatoDTO")
    ClienteDTO toDTOComContatos(Cliente cliente);
}