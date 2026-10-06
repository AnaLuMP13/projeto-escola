package com.unifacisa.escola.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    // Relacionamento Many to Many entre aluno e materia
    @ManyToMany
    @JoinTable(
            name = "aluno_materia",
            joinColumns = @JoinColumn(name="aluno_id"),
            inverseJoinColumns = @JoinColumn(name="materia_id")
    )
    private List<Materia> materias = new ArrayList<>();

    // Relacionamento Many to Many entre professor e aluno
    @ManyToMany(mappedBy = "alunos") // Atributo "Alunos" da classe professor "coordena" o relacionamento
    @JsonIgnore
    private Set<Professor> professores = new HashSet<>();

}