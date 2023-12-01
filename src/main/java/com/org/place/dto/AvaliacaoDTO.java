package com.org.place.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;

public class AvaliacaoDTO {
    private Long id;

    @NotBlank(message = "Periodo é obrigatótio!")
    private String periodo;

    @FutureOrPresent(message = "A data de inicio não pode comecar no dia anterior.")
    @JsonFormat(pattern = "dd/MM/yyyy'T'HH:mm")
    private LocalDateTime dataInicio;

    @FutureOrPresent(message = "A data de fim não pode começar no dia anterior.")
    @JsonFormat(pattern = "dd/MM/yyyy'T'HH:mm")
    private LocalDateTime dataFim;

    private List<Long> idFormulario;

    public AvaliacaoDTO(Long id, String periodo, LocalDateTime dataInicio, LocalDateTime dataFim, List<Long> idFormulario) {
        this.id = id;
        this.periodo = periodo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.idFormulario = idFormulario;
    }

    public AvaliacaoDTO(){}

    public AvaliacaoDTO(Long id, String periodo, LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.id = id;
        this.periodo = periodo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public List<Long> getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(List<Long> idFormulario) {
        this.idFormulario = idFormulario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }
}
