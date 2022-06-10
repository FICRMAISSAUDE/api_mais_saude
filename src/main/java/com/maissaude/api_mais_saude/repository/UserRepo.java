package com.maissaude.api_mais_saude.repository;

import com.maissaude.api_mais_saude.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maissaude.api_mais_saude.model.Usuario;

public interface UserRepo extends JpaRepository<Usuario, Long> {
}