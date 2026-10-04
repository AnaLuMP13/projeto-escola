package com.unifacisa.escola.services;

import com.unifacisa.escola.entities.Aluno;
import com.unifacisa.escola.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno salvarAluno(Aluno aluno) { return alunoRepository.save(aluno); }

    public List<Aluno> listarAlunos() { return alunoRepository.findAll(); }

    public Aluno atualizarAluno(Integer matricula, Aluno alunoAtualizado) {
        Aluno alunoExistente = alunoRepository.findById(matricula).orElseThrow(() -> new RuntimeException("Matrícula não encontrada."));

        alunoExistente.setNome(alunoAtualizado.getNome());
        alunoExistente.setTelefone(alunoAtualizado.getTelefone());
        alunoExistente.setEndereco(alunoAtualizado.getEndereco());

        return alunoRepository.save(alunoExistente);
    }

    public void deletarAluno (Integer matricula) { alunoRepository.deleteById(matricula); }
}