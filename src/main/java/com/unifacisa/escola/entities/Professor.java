package com.unifacisa.escola.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Definindo: Entidade, nome da tabela, Construtores, getters  e setters
@Entity
@Table(name = "professores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer matricula; // Chave primária gerada automáticamente

    @Column(nullable = false)
    private String nome;
    private int cpf;
    private int telefone;
    private String endereco;


    // Relacionamento "Muitos para muitos": Professores e alunos
    @ManyToMany
    @JoinTable(
            name = "professor_aluno", // Nome da tabela intermediária
            joinColumns = @JoinColumn(name = "professor_id"), // Coluna da classe Professor
            inverseJoinColumns = @JoinColumn(name = "aluno_id") // Coluna da classe Aluno
    )
    private Set<Aluno> alunos = new HashSet<>();

    // Um professor pode estar associado a várias matérias
    @OneToMany
    @JoinColumn(name = "professor_id") // coluna criada na tabela materias
    private List<Materia> materias = new ArrayList<>();
}