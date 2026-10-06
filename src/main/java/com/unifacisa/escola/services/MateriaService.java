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
public class MateriaService {

    // Ligação com o repositorio
    @Autowired
    private MateriaRepository materiaRepository;

    // POST: para cadastrar uma nova materia
    public Materia materiaPost(Materia materia) {
        return materiaRepository.save(materia);
    }

    // GET: para listar as materias
    public List<Materia> materiaGet() {
        return materiaRepository.findAll();
    }

    // UPDATE: para atualizar usando o id da materia
    public Materia materiaPut(Integer idMateria, Materia dadosAtualizados) {
        Materia materiaExistente = materiaRepository.findById(idMateria).orElseThrow(() -> new RuntimeException("Matéria não encontrada."));

        materiaExistente.setNome(dadosAtualizados.getNome());
        materiaExistente.setDescricao(dadosAtualizados.getDescricao());
        materiaExistente.setCargaHoraria(dadosAtualizados.getCargaHoraria());

        return materiaRepository.save(materiaExistente);
    }

    // DELETE: para apagar usando o id da materia
    public void materiaDelete(Integer idMateria) {
        materiaRepository.deleteById(idMateria);
    }
}
