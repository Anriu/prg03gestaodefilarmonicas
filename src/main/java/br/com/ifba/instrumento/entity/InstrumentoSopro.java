package br.com.ifba.instrumento.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Representa a especialização dos instrumentos de sopro.
 * Define características comuns compartilhadas pelas subclasses
 * de madeira e metal.
 *
 * @author anriu
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class InstrumentoSopro extends Instrumento {

    /**
     * Afinação principal do instrumento.
     */
    private String afinacao;
}