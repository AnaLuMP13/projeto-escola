package com.unifacisa.escola.controllers;

import com.unifacisa.escola.entities.Certificado;
import com.unifacisa.escola.entities.Professor;
import com.unifacisa.escola.services.CertificadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificados")
public class CertificadoController {
    @Autowired
    private CertificadoService certificadoService;

    // Mapeando a funcionalidade POST
    @PostMapping
    public Certificado cadastrarCertificado(@RequestBody Certificado certificado) {
        return certificadoService.salvarCertificado(certificado);
    }

    // Mapeando funcionalidade GET
    @GetMapping
    public List<Certificado> listarCertificados(){
        return certificadoService.listarCertificados();
    }

    // Mapeando funcionalidade UPDATE
    @PutMapping("/{idCertificado}")
    public Certificado atualizarCertificado(@PathVariable Integer idCertificado, @RequestBody Certificado certificado) {
        return certificadoService.atualizarCertificado(idCertificado, certificado);
    }

    // Mapeando funcionalidade DELETE
    @DeleteMapping("/{idCertificado}")
    public String excluirCertificado(@PathVariable Integer idCertificado) {
        certificadoService.deletarCertificado(idCertificado);

        return "Certificado excluído com sucesso";
    }

    // Mapeando funcionalidade certificado - aluno
    @PutMapping("/{idCertificado}/alunos/{matricula}")
    public String vincularCertificado(@PathVariable Integer idCertificado, @PathVariable Integer matricula) {
        certificadoService.vincularAluno(idCertificado, matricula);
        return "Aluno vinculado ao certificado com sucesso.";
    }
}