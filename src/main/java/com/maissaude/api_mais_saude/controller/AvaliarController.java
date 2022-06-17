package com.maissaude.api_mais_saude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maissaude.api_mais_saude.model.Avaliar;
import com.maissaude.api_mais_saude.repository.AulaRepo;
import com.maissaude.api_mais_saude.repository.AvaliarRepo;

@RestController
@RequestMapping(value = "/avaliar")
public class AvaliarController {

    @Autowired
    private AvaliarRepo avaliarRepo;

    // Consultar todas as avaliações
    @GetMapping
    public List<Avaliar> findAll() {
        return avaliarRepo.findAll();
    }

    // Consultar as Avaliações individualmente inserindo o /id
    @GetMapping("/{idAvaliar}")
    public Avaliar show(@PathVariable Long idAvaliar) {
        return avaliarRepo.findById(idAvaliar).orElse(null);
    }

    // Cadastra Avaliação
    @PostMapping
    public String save(@RequestBody Avaliar newAvaliar) {
        // validando se ja existe a Avaliação antes de cadastrar

        if ((newAvaliar.getAulaId() != null) && (newAvaliar.getIdUsuario() != null)
                && (newAvaliar.getEstrela() != null)
                && (newAvaliar.getComentario() != null)) {

            avaliarRepo.save(newAvaliar);

            return "Aula avaliada com sucesso!";

        } else {
            return "Preencha todos os campos!";

        }
    }

    // Atualizar Avaliação
    @PutMapping("/{idAvaliar}")
    public String update(@RequestBody Avaliar updateUser, @PathVariable Long idAvaliar) {
        if (avaliarRepo.existsById(idAvaliar)) {
            // Verificando cada campo se é nulo ou diferente do que ja estava inserido
            // para poder atualizar
            Avaliar user_db = avaliarRepo.findById(idAvaliar).orElse(null);
            if ((updateUser.getEstrela() != null) && (user_db.getEstrela() != updateUser.getEstrela())) {
                user_db.setEstrela(updateUser.getEstrela());
            }
            if ((updateUser.getComentario() != null) && (user_db.getComentario() != updateUser.getComentario())) {
                user_db.setComentario(updateUser.getComentario());
            }
            if ((updateUser.getAulaId() != null) && (user_db.getAulaId() != updateUser.getAulaId())) {
                user_db.setAulaId(updateUser.getAulaId());
            }
            avaliarRepo.save(user_db);
            return "Avaliação atualizada com sucesso";
        } else {
            return "Avaliação não encontrada!";
        }
    }

    // Deleter Avaliação
    @DeleteMapping("/{idAvaliar}")
    public String delete(@PathVariable Long idAvaliar) {
        if (avaliarRepo.existsById(idAvaliar)) {
            avaliarRepo.deleteById(idAvaliar);
            return "Avaliação deletada com sucesso!";
        } else {
            return "Avaliação não encontrada!";
        }
    }

}
