package com.org.place.controller;

import com.org.place.dto.AvaliacaoDTO;
import com.org.place.dto.FormularioDTO;
import com.org.place.entity.Avaliacao;
import com.org.place.entity.Formulario;
import com.org.place.service.FormularioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/formulario")
public class FormularioController {
    private final FormularioService formularioService;

    public FormularioController(FormularioService formularioService) {
        this.formularioService = formularioService;
    }

    @PostMapping("/")
    public ResponseEntity<Formulario> savarTodos(@RequestBody @Valid FormularioDTO formularioDTO){
        return new ResponseEntity<>(formularioService.salvar(formularioDTO), HttpStatus.CREATED);
    }
}
