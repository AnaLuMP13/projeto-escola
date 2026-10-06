package com.unifacisa.escola.services;

import com.unifacisa.escola.entities.Aluno;
import com.unifacisa.escola.entities.Materia;
import com.unifacisa.escola.repositories.AlunoRepository;
import com.unifacisa.escola.repositories.MateriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private MateriaRepository materiaRepository;

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

    // Função para vincular um aluno a uma materia
    @Transactional
    public void vincularMateria(Integer alunoId, Integer idMateria) {
        Materia materia = materiaRepository.findById(idMateria).orElseThrow(() -> new RuntimeException("Matéria não encontrada."));
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new RuntimeException("Aluno não encontrado."));
        aluno.getMaterias().add(materia);

        alunoRepository.save(aluno);
    }
}