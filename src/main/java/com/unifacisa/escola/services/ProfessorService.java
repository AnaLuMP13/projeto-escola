package com.unifacisa.escola.services;

import com.unifacisa.escola.entities.Aluno;
import com.unifacisa.escola.entities.Materia;
import com.unifacisa.escola.entities.Professor;
import com.unifacisa.escola.repositories.AlunoRepository;
import com.unifacisa.escola.repositories.MateriaRepository;
import com.unifacisa.escola.repositories.ProfessorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    // Inicia a "ligação" com o repositório
    @Autowired
    public ProfessorRepository professorRepository;
    @Autowired
    private AlunoRepository alunoRepository; // Vinculo para realizar o Many to Many
    @Autowired
    private MateriaRepository materiaRepository; // Vinculo para realizar o One to Many

    // Função POST: salva um novo professor na tabela
    public Professor professorPost(Professor professor) {
        return professorRepository.save(professor);
    }

    // Função GET: lista todos os professores presentes na tabela
    public List<Professor> professorGet() {
        return professorRepository.findAll();
    }

    // Função UPDATE: atualiza os dados de um professor pelo ID
    public Professor professorPut(Integer matricula, Professor dadosAtualizados) {
        Professor professorExistente = professorRepository.findById(matricula).orElseThrow(() -> new RuntimeException("Matrícula não encontrada."));


        professorExistente.setNome(dadosAtualizados.getNome());
        professorExistente.setEndereco(dadosAtualizados.getEndereco());
        professorExistente.setTelefone(dadosAtualizados.getTelefone());
        professorExistente.setCpf(dadosAtualizados.getCpf());

        return professorRepository.save(professorExistente);
    }

    // Função DELETE: apagar um professor da tabela pelo ID
    public void professorDelete(Integer matricula) {
        professorRepository.deleteById(matricula);
    }

    // Função Many to Many: Professor - aluno
    @Transactional
    public void vincularAluno(Integer matricula, Integer alunoId) {
        Professor professor = professorRepository.findById(matricula).orElseThrow(() -> new RuntimeException("Professor não encontrado."));
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new RuntimeException("Aluno não encontrado."));
        professor.getAlunos().add(aluno);

        professorRepository.save(professor);
    }

    // Vinculo professor - materia : Relacionamento One to Many
    @Transactional
    public void vincularMateria(Integer matricula, Integer idMateria) {
        Professor professor = professorRepository.findById(matricula).orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        Materia materia = materiaRepository.findById(idMateria).orElseThrow(() -> new RuntimeException("Matéria não encontrada"));
        professor.getMaterias().add(materia);

        professorRepository.save(professor);
    }
}
