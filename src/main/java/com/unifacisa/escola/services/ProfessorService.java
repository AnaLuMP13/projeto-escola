package com.unifacisa.escola.services;

import com.unifacisa.escola.entities.Professor;
import com.unifacisa.escola.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    // Inicia a "ligação" com o repositório
    @Autowired
    public ProfessorRepository professorRepository;

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
}
