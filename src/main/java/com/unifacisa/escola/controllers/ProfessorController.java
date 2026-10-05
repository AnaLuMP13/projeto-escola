package com.unifacisa.escola.controllers;

import com.unifacisa.escola.entities.Professor;
import com.unifacisa.escola.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Definindo: Classe controller e rota
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
}
