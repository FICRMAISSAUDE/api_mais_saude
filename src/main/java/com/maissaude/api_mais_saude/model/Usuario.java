package com.maissaude.api_mais_saude.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.NonNull;

@Entity
public class Usuario {
    private Long id;
    @NonNull
    private String nome;
    private String perfil;
    private String email;
    private String cep;
    private String nascimento;
    private String endereco;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String perfil, String email, String cep, String nascimento, String endereco) {
        this.id = id;
        this.nome = nome;
        this.perfil = perfil;
        this.email = email;
        this.cep = cep;
        this.nascimento = nascimento;
        this.endereco = endereco;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String fullName() {
        return this.nome + " " + this.perfil;
    }

}
