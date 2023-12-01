package com.org.place.service;

import com.org.place.dto.AvaliacaoDTO;
import com.org.place.dto.shallow.AvaliacaoShallowDTO;
import com.org.place.entity.Avaliacao;
import com.org.place.entity.Formulario;
import com.org.place.mapper.AvaliacaoMapper;
import com.org.place.repository.AvaliacaoRepository;
import com.org.place.repository.FormularioRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AvaliacaoService {
    private final FormularioRepository formularioRepository;
    private final AvaliacaoRepository avaliacaoRepository;

    private final AvaliacaoMapper avaliacaoMapper;

    public AvaliacaoService(FormularioRepository formularioRepository, AvaliacaoRepository avaliacaoRepository, AvaliacaoMapper avaliacaoMapper) {
        this.formularioRepository = formularioRepository;
        this.avaliacaoRepository = avaliacaoRepository;
        this.avaliacaoMapper = avaliacaoMapper;
    }

    public List<Avaliacao> listar(AvaliacaoDTO filter, Pageable pageable) {
        Page<Avaliacao> page = avaliacaoRepository.findAll(new Specification<Avaliacao>() {
            @Override
            public Predicate toPredicate(Root<Avaliacao> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (Objects.nonNull(filter.getDataInicio())) {
                    predicates.add(criteriaBuilder.equal(root.<LocalDateTime>get("dataInicio"), filter.getDataInicio()));
                }

                if (Objects.nonNull(filter.getDataFim())) {
                    predicates.add(criteriaBuilder.equal(root.<LocalDateTime>get("dataFim"), filter.getDataFim()));
                }

                if (Objects.nonNull(filter.getPeriodo())) {
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("periodo")), "%" + filter.getPeriodo()));
                }

                if (Objects.nonNull(filter.getId())) {
                    predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get("id")), + filter.getId()));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }

        }, pageable);

        return page.getContent();
    }

    public Avaliacao findById(Long id){
        return avaliacaoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    public Avaliacao salvar(AvaliacaoDTO avaliacaoDTO){
        Avaliacao avaliacao = avaliacaoMapper.avaliacaoToDTO(avaliacaoDTO);
        Avaliacao avaliacaoSaved = avaliacaoRepository.save(avaliacao);

        return avaliacaoSaved;
    }

    public void vincularEntidades(Long idAvaliacao, List<Long> formularioId){
        Avaliacao avaliacao = avaliacaoRepository.findById(idAvaliacao)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe essa avaliação: " + idAvaliacao));

        if(avaliacao != null) {
            List<Formulario> formularios = (List<Formulario>) formularioRepository.findAllById(formularioId);
            avaliacao.getFormularios().addAll(formularios);
            avaliacaoRepository.save(avaliacao);
        }
    }

    public void atualizar(AvaliacaoDTO avaliacaoDTO){
        Avaliacao avaliacaoOld = findById(avaliacaoDTO.getId());
        Avaliacao avaliacao = avaliacaoMapper.avaliacaoToDTO(avaliacaoDTO);

        avaliacao.setId(avaliacaoOld.getId());
        avaliacaoRepository.save(avaliacao);
    }

    public void deletar(Long id){
        avaliacaoRepository.delete(findById(id));
    }
}
