package com.org.place.controller;

import com.org.place.dto.AvaliacaoDTO;
import com.org.place.dto.shallow.AvaliacaoShallowDTO;
import com.org.place.entity.Avaliacao;
import com.org.place.service.AvaliacaoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/avaliacao")
@CrossOrigin(origins = "http://localhost:4200")
public class AvaliacaoController {
    private final AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Avaliacao>> listarTodos(AvaliacaoDTO avaliacaoDTO, Pageable pageable){
        return new ResponseEntity<>(avaliacaoService.listar(avaliacaoDTO, pageable), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Avaliacao> savarTodos(@RequestBody @Valid AvaliacaoDTO avaliacaoDTO){
        return new ResponseEntity<>(avaliacaoService.salvar(avaliacaoDTO), HttpStatus.CREATED);
    }

    @PostMapping("/{avaliacaoId}/vincular")
    public ResponseEntity<Avaliacao> vincularFormulario(@PathVariable Long avaliacaoId,
                                                     @RequestBody AvaliacaoDTO avaliacaoDTO){
        avaliacaoService.vincularEntidades(avaliacaoId, avaliacaoDTO.getIdFormulario());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTodos(@PathVariable Long id){
        avaliacaoService.deletar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
