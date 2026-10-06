package com.unifacisa.escola.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private int cargaHoraria;

    // Relacionamento muitos para muitos entre materia e aluno
    @ManyToMany(mappedBy = "materias")
    @JsonIgnore
    private List<Aluno> alunos = new ArrayList<>();

    // Muitas matérias podem estar associadas a um único professor
    @ManyToOne
    @JoinColumn(name = "professor_id", insertable = false, updatable = false) // Transforma a coluna em apenas leitura
    @JsonIgnore
    private Professor professor;
}