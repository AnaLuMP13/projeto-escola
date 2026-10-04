package com.unifacisa.escola.controllers;

import com.unifacisa.escola.entities.Aluno;
import com.unifacisa.escola.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoContoller {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        return alunoService.salvarAluno(aluno);
    }

    @GetMapping
    public List<Aluno> listarAlunos() { return alunoService.listarAlunos(); }

    @PutMapping("/{matricula}")
    public Aluno atualizarAluno(@PathVariable Integer matricula, @RequestBody Aluno aluno) {
        return alunoService.atualizarAluno(matricula, aluno);
    }

    @DeleteMapping("/{matricula}")
    public String excluirAluno(@PathVariable Integer matricula) {
        alunoService.deletarAluno(matricula);

        return "Aluno excluído com sucesso.";
    }
}