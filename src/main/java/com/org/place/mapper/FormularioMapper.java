package com.org.place.mapper;

import com.org.place.dto.FormularioDTO;
import com.org.place.entity.Formulario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FormularioMapper {
    FormularioMapper INSTANCE = Mappers.getMapper(FormularioMapper.class);

    Formulario formularioToDto(FormularioDTO formularioDTO);
}
