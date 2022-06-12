package com.maissaude.api_mais_saude.controller;

import java.util.List;

import com.maissaude.api_mais_saude.model.Usuario;
import com.maissaude.api_mais_saude.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public Usuario show(@PathVariable Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @PostMapping
    public String save(@RequestBody Usuario newUser) {

        userRepo.save(newUser);
        return "Usuário cadastrado com sucesso!";

    }

    @PutMapping("/{id}")
    public String update(@RequestBody Usuario updateUser, @PathVariable Long id) {
        if (userRepo.existsById(id)) {
            Usuario user_db = userRepo.findById(id).orElse(null);
            if ((updateUser.getEmail() != null) && (user_db.getEmail() != updateUser.getEmail())) {
                user_db.setEmail(updateUser.getEmail());
            }
            if ((updateUser.getNome() != null) && (user_db.getNome() != updateUser.getNome())) {
                user_db.setNome(updateUser.getNome());
            }
            if ((updateUser.getPerfil() != null) && (user_db.getPerfil() != updateUser.getPerfil())) {
                user_db.setPerfil(updateUser.getPerfil());
            }
            if ((updateUser.getCep() != null) && (user_db.getCep() != updateUser.getCep())) {
                user_db.setCep(updateUser.getCep());
            }
            if ((updateUser.getNascimento() != null) && (user_db.getNascimento() != updateUser.getNascimento())) {
                user_db.setNascimento(updateUser.getNascimento());
            }
            if ((updateUser.getEndereco() != null) && (user_db.getEndereco() != updateUser.getEndereco())) {
                user_db.setEndereco(updateUser.getEndereco());
            }
            userRepo.save(user_db);
            return "usuario " + user_db.fullName() + " atualizado com sucesso";
        } else {
            return "Usuário não encontrado!";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return "Usuário deletado com sucesso!";
        } else {
            return "Usuário não encontrado!";
        }
    }

}
