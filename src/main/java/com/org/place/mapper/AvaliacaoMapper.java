package com.org.place.mapper;

import com.org.place.dto.AvaliacaoDTO;
import com.org.place.entity.Avaliacao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AvaliacaoMapper {
    AvaliacaoMapper INSTANCE = Mappers.getMapper(AvaliacaoMapper.class);

    Avaliacao avaliacaoToDTO(AvaliacaoDTO avaliacaoDTO);
}
