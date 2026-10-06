package com.unifacisa.escola.services;

import com.unifacisa.escola.entities.Aluno;
import com.unifacisa.escola.entities.Certificado;
import com.unifacisa.escola.entities.Materia;
import com.unifacisa.escola.entities.Professor;
import com.unifacisa.escola.repositories.AlunoRepository;
import com.unifacisa.escola.repositories.CertificadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificadoService {
    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CertificadoRepository certificadoRepository;

    public Certificado salvarCertificado(Certificado certificado) { return certificadoRepository.save(certificado); }

    public List<Certificado> listarCertificados() { return certificadoRepository.findAll(); }

    public Certificado atualizarCertificado(Integer idCertificado, Certificado certificadoAtualizado) {
        Certificado certificadoExistente = certificadoRepository.findById(idCertificado).orElseThrow(() -> new RuntimeException("Certificado não encontrado."));

        certificadoExistente.setCargaHoraria(certificadoAtualizado.getCargaHoraria());
        certificadoExistente.setAtividadeComplementar(certificadoAtualizado.getAtividadeComplementar());

        return certificadoRepository.save(certificadoExistente);
    }

    public void deletarCertificado (Integer idCertificado) { certificadoRepository.deleteById(idCertificado); }

    @Transactional
    public void vincularAluno(Integer idCertificado, Integer matricula) {
        Certificado certificado = certificadoRepository.findById(idCertificado).orElseThrow(() -> new RuntimeException("Certificado não encontrado"));
        Aluno aluno = alunoRepository.findById(matricula).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        certificado.setAluno(aluno);

        certificadoRepository.save(certificado);
    }
}