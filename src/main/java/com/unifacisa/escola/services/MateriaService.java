package com.unifacisa.escola.services;

import com.unifacisa.escola.entities.Materia;
import com.unifacisa.escola.repositories.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    // POST: para criar uma nova materia
    public Materia materiaPost(Materia materia) {
        return materiaRepository.save(materia);
    }

    // GET: para buscar uma materia
    public List<Materia> materiaGet() {
        return materiaRepository.findAll();
    }

    // PUT: para atualizar usando o id da materia
    public Materia materiaPut(Integer idMateria, Materia materia) {
        Materia materiaExistente = materiaRepository.findById(idMateria).orElseThrow();

        materiaExistente.setNome(materia.getNome());
        materiaExistente.setDescricao(materia.getDescricao());
        materiaExistente.setCargaHoraria(materia.getCargaHoraria());
        materiaExistente.setProfessor(materia.getProfessor());

        return materiaRepository.save(materiaExistente);
    }

    // DELETE: para apagar usando o id da materia
    public void materiaDelete(Integer idMateria) {
        materiaRepository.deleteById(idMateria);
    }
}
