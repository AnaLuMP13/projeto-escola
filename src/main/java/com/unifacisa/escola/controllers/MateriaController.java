package com.unifacisa.escola.controllers;

import com.unifacisa.escola.entities.Materia;
import com.unifacisa.escola.services.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    // Para fazer a ligação com o service
    @Autowired
    private MateriaService materiaService;

    // Mapeia a função POST usada no cadastro de uma nova materia
    @PostMapping
    public Materia cadastrarMateria(@RequestBody Materia materia) {
        return materiaService.materiaPost(materia);
    }

    // Mapeia a função GET usada na listagem das materias
    @GetMapping
    public List<Materia> listarMateria() {
        return materiaService.materiaGet();
    }

    // Mapeia a função PUT usando o id passado na URL
    @PutMapping("/{idMateria}")
    public Materia atualizarMateria(@PathVariable Integer idMateria, @RequestBody Materia materia) {
        return materiaService.materiaPut(idMateria, materia);
    }

    // Mapeia a função DELETE usando o id passado na URL
    @DeleteMapping("/{idMateria}")
    public String excluirMateria(@PathVariable Integer idMateria) {
        materiaService.materiaDelete(idMateria);

        return "Matéria excluída com sucesso";
    }

    // Mapeia a função de vincular o aluno a materia
    @PostMapping("/{idMateria}/alunos/{alunoId}")
    public String vincularAluno(@PathVariable Integer idMateria, @PathVariable Integer alunoId) {
        materiaService.vincularAluno(idMateria, alunoId);

        return "Aluno vinculado à matéria com sucesso.";
    }
}
