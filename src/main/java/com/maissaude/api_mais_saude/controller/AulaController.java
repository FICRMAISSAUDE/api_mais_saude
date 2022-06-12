package com.maissaude.api_mais_saude.controller;

import java.util.List;

import com.maissaude.api_mais_saude.model.Aula;
import com.maissaude.api_mais_saude.repository.AulaRepo;

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
@RequestMapping(value = "/aulas")
public class AulaController {

    @Autowired
    private AulaRepo aulaRepo;

    @GetMapping
    public List<Aula> findAll() {
        return aulaRepo.findAll();
    }

    @GetMapping("/{idAula}")
    public Aula show(@PathVariable Long idAula) {
        return aulaRepo.findById(idAula).orElse(null);
    }

    @PostMapping
    public String save(@RequestBody Aula newAula) {
        if ((newAula.getIdAula() != null) && (newAula.getNomeAula() != null) && (newAula.getLocal() != null)
                && (newAula.getData() != null) && (newAula.getHorario() != null)) {
            aulaRepo.save(newAula);

            return "Aula cadastrada com sucesso!";

        } else {
            return "Preencha todos os campos!";

        }

    }

    @PutMapping("/{idAula}")
    public String update(@RequestBody Aula updateUser, @PathVariable Long idAula) {
        if (aulaRepo.existsById(idAula)) {
            Aula user_db = aulaRepo.findById(idAula).orElse(null);
            if ((updateUser.getNomeAula() != null) && (user_db.getNomeAula() != updateUser.getNomeAula())) {
                user_db.setNomeAula(updateUser.getNomeAula());
            }
            if ((updateUser.getLocal() != null) && (user_db.getLocal() != updateUser.getLocal())) {
                user_db.setLocal(updateUser.getLocal());
            }
            if ((updateUser.getData() != null) && (user_db.getData() != updateUser.getData())) {
                user_db.setData(updateUser.getData());
            }
            if ((updateUser.getHorario() != null) && (user_db.getHorario() != updateUser.getHorario())) {
                user_db.setHorario(updateUser.getHorario());
            }
            if ((updateUser.getTipoAtividade() != null)
                    && (user_db.getTipoAtividade() != updateUser.getTipoAtividade())) {
                user_db.setTipoAtividade(updateUser.getTipoAtividade());
            }
            if ((updateUser.getObservacoes() != null) && (user_db.getObservacoes() != updateUser.getObservacoes())) {
                user_db.setObservacoes(updateUser.getObservacoes());
            }
            aulaRepo.save(user_db);
            return "Aula atualizada com sucesso";
        } else {
            return "Aula não encontrada!";
        }
    }

    @DeleteMapping("/{idAula}")
    public String delete(@PathVariable Long idAula) {
        if (aulaRepo.existsById(idAula)) {
            aulaRepo.deleteById(idAula);
            return "Aula deletada com sucesso!";
        } else {
            return "Aula não encontrada!";
        }
    }

}
