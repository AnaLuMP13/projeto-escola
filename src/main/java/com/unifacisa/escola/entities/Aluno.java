package com.unifacisa.escola.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alunos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer matricula;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int telefone;

    @Column(nullable = false)
    private String endereco;

    @ManyToMany
    @JoinTable(
            name = "aluno_professor",
            joinColumns = @JoinColumn(name="aluno_id"),
            inverseJoinColumns = @JoinColumn(name="professor_id")
    )
    private List<Professor> professores = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "aluno_materia",
            joinColumns = @JoinColumn(name="aluno_id"),
            inverseJoinColumns = @JoinColumn(name="materia_id")
    )
    private List<Materia> materias = new ArrayList<>();

}