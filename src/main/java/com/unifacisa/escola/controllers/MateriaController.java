package com.unifacisa.escola.controllers;

import com.unifacisa.escola.entities.Materia;
import com.unifacisa.escola.services.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    // Para fazer a ligação com o service de materia
    @Autowired
    private MateriaService materiaService;

    @PostMapping
    public Materia cadastrarMateria(@RequestBody Materia materia) {
        return materiaService.materiaPost(materia);
    }

    @GetMapping
    public List<Materia> listarMateria() {
        return materiaService.materiaGet();
    }

    @PutMapping("/{idMateria}")
    public Materia atualizarMateria(@PathVariable Integer idMateria, @RequestBody Materia materia) {
        return materiaService.materiaPut(idMateria, materia);
    }

    @DeleteMapping("/{idMateria}")
    public String excluirMateria(@PathVariable Integer idMateria) {
        materiaService.materiaDelete(idMateria);

        return "Matéria excluída com sucesso";
    }
}
