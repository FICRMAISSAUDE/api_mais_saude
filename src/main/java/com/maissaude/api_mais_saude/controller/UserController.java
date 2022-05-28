package com.maissaude.api_mais_saude.controller;

import java.util.List;

import com.maissaude.api_mais_saude.model.Usuario;
import com.maissaude.api_mais_saude.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public List<Usuario> findAll() {
        return userRepo.findAll();
    }

    @PostMapping
    public Usuario save(@RequestBody Usuario newUser) {
        return userRepo.save(newUser);
    }

    @PutMapping
    @PostMapping
    public Usuario update(@RequestBody Usuario updateUser) {
        return userRepo.save(updateUser);
    }
}
