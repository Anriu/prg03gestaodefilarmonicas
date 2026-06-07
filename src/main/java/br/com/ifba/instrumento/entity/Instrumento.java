package br.com.ifba.instrumento.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity; // Importa a classe de infraestrutura
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_instrumento")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_instrumento", discriminatorType = DiscriminatorType.STRING)
@Data
@EqualsAndHashCode(callSuper = true) // Importante para o Lombok herdar o ID corretamente no equals/hashCode
public abstract class Instrumento extends PersistenceEntity { 

    // O ID FOI REMOVIDO DAQUI pois agora é herdado automaticamente de PersistenceEntity

    private String nome;
    private String tipo;
    private String numSerie;
    private String marca;
    private String modelo;
    private String estadoConservacao;
}