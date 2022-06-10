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
    public Usuario save(@RequestBody Usuario newUser) {
        return userRepo.save(newUser);
    }

    @PutMapping("/{id}")
    public String update(@RequestBody Usuario updateUser, @PathVariable Long id) {
        if (userRepo.existsById(id)) {
            Usuario user_db = userRepo.findById(id).orElse(null);
            if ((updateUser.getEmail() != null) && (user_db.getEmail() != updateUser.getEmail())) {
                user_db.setEmail(updateUser.getEmail());
            }
            if ((updateUser.getFirstName() != null) && (user_db.getFirstName() != updateUser.getFirstName())) {
                user_db.setFirstName(updateUser.getFirstName());
            }
            if ((updateUser.getLastName() != null) && (user_db.getLastName() != updateUser.getLastName())) {
                user_db.setLastName(updateUser.getLastName());
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
