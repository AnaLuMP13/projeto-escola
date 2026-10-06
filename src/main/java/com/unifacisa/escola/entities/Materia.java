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

    // Muitas matérias podem estar associadas a um único professor
    @ManyToOne
    @JoinColumn(name = "professor_id", insertable = false, updatable = false) // Transforma a coluna em apenas leitura
    @JsonIgnore
    private Professor professor;
}