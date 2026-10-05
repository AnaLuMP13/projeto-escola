package com.unifacisa.escola.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}