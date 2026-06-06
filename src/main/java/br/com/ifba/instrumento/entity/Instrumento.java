package br.com.ifba.instrumento.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_instrumento")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Estratégia de herança de alta performance
@DiscriminatorColumn(name = "tipo_instrumento", discriminatorType = DiscriminatorType.STRING)
@Data // Gerador de getters/setters do Lombok
public abstract class Instrumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numSerie;
    private String marca;
    private String modelo;
    private String estadoConservacao;
}