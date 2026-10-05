package com.unifacisa.escola.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "materias")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idMateria;

    @Column(nullable = false)
    private String nome;
    private String descricao;
    private int cargaHoraria;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    @JsonIgnore
    private Professor professor;
}