package com.unifacisa.escola.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "certificados")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCertificado;

    @Column(nullable = false)
    private int cargaHoraria;

    @Column(nullable = false)
    private String atividadeComplementar;

    @OneToOne
    @JoinColumn(name = "aluno_id", unique = true)
    private Aluno aluno;
}