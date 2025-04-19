package com.nubank.nuclientes.mapper;

import com.nubank.nuclientes.dto.ContatoDTO;
import com.nubank.nuclientes.entity.Contato;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContatoMapper {

    ContatoMapper INSTANCE = Mappers.getMapper(ContatoMapper.class);

    @Named("toContatoDTO")
    @Mapping(source = "cliente.id", target = "clienteId")
    ContatoDTO toDTO(Contato contato);

    @Mapping(source = "clienteId", target = "cliente.id")
    Contato toEntity(ContatoDTO dto);
}