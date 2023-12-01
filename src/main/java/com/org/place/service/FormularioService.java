package com.org.place.service;

import com.org.place.dto.FormularioDTO;
import com.org.place.entity.Formulario;
import com.org.place.mapper.FormularioMapper;
import com.org.place.repository.FormularioRepository;
import org.springframework.stereotype.Service;

@Service
public class FormularioService {
    private final FormularioRepository formularioRepository;

    private final FormularioMapper formularioMapper;

    public FormularioService(FormularioRepository formularioRepository, FormularioMapper formularioMapper) {
        this.formularioRepository = formularioRepository;
        this.formularioMapper = formularioMapper;
    }

    public Formulario salvar(FormularioDTO formularioDTO){
        Formulario formulario = formularioMapper.formularioToDto(formularioDTO);
        Formulario formularioSaved = formularioRepository.save(formulario);

        return formularioSaved;
    }
}
