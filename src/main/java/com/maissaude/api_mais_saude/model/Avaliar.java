package com.maissaude.api_mais_saude.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.NonNull;

@Entity
public class Avaliar {
    private Long idAvaliar;
    @NonNull
    private Long aulaId;
    private Long idUsuario;
    private Integer estrela;
    private String comentario;

    public Avaliar() {
    }

    public Avaliar(Long idAvaliar, Long aulaId, Long idUsuario, Integer estrela, String comentario) {
        this.idAvaliar = idAvaliar;
        this.aulaId = aulaId;
        this.idUsuario = idUsuario;
        this.estrela = estrela;
        this.comentario = comentario;
    }

    @Id
    @GeneratedValue
    public Long getIdAvaliar() {
        return idAvaliar;
    }

    public void setIdAvaliar(Long idAvaliar) {
        this.idAvaliar = idAvaliar;
    }

    public Long getAulaId() {
        return aulaId;
    }

    public void setAulaId(Long aulaId) {
        this.aulaId = aulaId;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getEstrela() {
        return estrela;
    }

    public void setEstrela(Integer estrela) {
        this.estrela = estrela;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}