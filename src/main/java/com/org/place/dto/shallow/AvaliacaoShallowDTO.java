package com.org.place.dto.shallow;

import java.time.LocalDateTime;
import java.util.List;

public class AvaliacaoShallowDTO {
    private Long id;
    private String periodo;
    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    public AvaliacaoShallowDTO(){}

    public AvaliacaoShallowDTO(Long id, String periodo, LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.id = id;
        this.periodo = periodo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
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
