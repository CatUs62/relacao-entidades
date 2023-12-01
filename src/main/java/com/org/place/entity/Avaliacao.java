package com.org.place.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "avaliacao")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String periodo;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "avaliacao_formularios",
                joinColumns = @JoinColumn(name = "avaliacoes_id"),
                inverseJoinColumns = @JoinColumn(name = "formularios_id"))
    @JsonManagedReference
    private List<Formulario> formularios;

    public Avaliacao(Long id, String periodo, LocalDateTime dataInicio, LocalDateTime dataFim, List<Formulario> formularios) {
        this.id = id;
        this.periodo = periodo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.formularios = formularios;
    }

    public Avaliacao(){}

    public Avaliacao(Long id, String periodo, LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.id = id;
        this.periodo = periodo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public List<Formulario> getFormularios() {
        return formularios;
    }

    public void setFormularios(List<Formulario> formularios) {
        this.formularios = formularios;
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
