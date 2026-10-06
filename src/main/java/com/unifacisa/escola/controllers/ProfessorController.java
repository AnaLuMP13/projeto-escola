package com.unifacisa.escola.controllers;

import com.unifacisa.escola.entities.Professor;
import com.unifacisa.escola.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Definindo: Classe controller e rota
@RestController
@RequestMapping("/professores")
public class ProfessorController {

    // Iniciando "ligação" com o service
    @Autowired
    private ProfessorService professorService;

    // Mapeando a funcionalidade POST
    @PostMapping
    public Professor cadastrarProfessor(@RequestBody Professor professor) {
        return professorService.professorPost(professor);
    }

    // Mapeando funcionalidade GET
    @GetMapping
    public List<Professor> listarProfessor(){
        return professorService.professorGet();
    }

    // Mapeando funcionalidade UPDATE
    @PutMapping("/{matricula}")
    public Professor atualizarProfessor(@PathVariable Integer matricula, @RequestBody Professor professor) {
        return professorService.professorPut(matricula, professor);
    }

    // Mapeando funcionalidade DELETE
    @DeleteMapping("/{matricula}")
    public String excluirProfessor(@PathVariable Integer matricula) {
        professorService.professorDelete(matricula);

        return "Professor excluído com sucesso";
    }

    // Mapeando funcionalidade professor - aluno
    @PostMapping("/{matricula}/alunos/{alunoId}")
    public String vincularAluno(@PathVariable Integer matricula, @PathVariable Integer alunoId) {
        professorService.vincularAluno(matricula, alunoId);
        return "Aluno vinculado ao professor com sucesso.";
    }

    // Mapeamento da funcionalidade professor - materia
    @PostMapping("/{matricula}/materias/{idMateria}")
    public String vincularMateria(@PathVariable Integer matricula, @PathVariable Integer idMateria) {
        professorService.vincularMateria(matricula, idMateria);

        return "Professor cadastrado na matéria com sucesso";
    }
}
