package br.com.ifba.instrumento.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import br.com.ifba.pessoa.entity.Aluno;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Classe base responsável por representar um instrumento musical.
 * Centraliza os atributos comuns compartilhados por todas as
 * especializações do sistema.
 *
 * Utiliza a estratégia SINGLE_TABLE para persistência das subclasses
 * em uma única tabela do banco de dados.
 *
 * @author anriu
 */
@Entity
@Table(name = "tb_instrumento")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class Instrumento extends PersistenceEntity {

    private String nome;
    private String tipo;
    private String numSerie;
    private String marca;
    private String modelo;
    private String estadoConservacao;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    private Aluno alunoResponsavel;

}