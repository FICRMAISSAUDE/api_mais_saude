package com.maissaude.api_mais_saude.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.NonNull;

@Entity
public class Aula {
    private Long idAula;
    @NonNull
    private String nomeAula;
    private String local;
    private String data;
    private String horario;
    private String tipoAtividade;
    private String observacoes;

    public Aula() {
    }

    public Aula(Long idAula, String nomeAula, String local, String data, String horario, String tipoAtividade,
            String observacoes) {
        this.idAula = idAula;
        this.nomeAula = nomeAula;
        this.local = local;
        this.data = data;
        this.horario = horario;
        this.tipoAtividade = tipoAtividade;
        this.observacoes = observacoes;
    }

    @Id
    @GeneratedValue
    public Long getIdAula() {
        return idAula;
    }

    public void setIdAula(Long idAula) {
        this.idAula = idAula;
    }

    public String getNomeAula() {
        return nomeAula;
    }

    public void setNomeAula(String nomeAula) {
        this.nomeAula = nomeAula;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTipoAtividade() {
        return tipoAtividade;
    }

    public void setTipoAtividade(String tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

}