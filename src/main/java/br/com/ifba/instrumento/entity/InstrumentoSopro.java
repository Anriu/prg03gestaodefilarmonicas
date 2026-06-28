package br.com.ifba.instrumento.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "tb_instrumento_sopro")
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class InstrumentoSopro extends Instrumento {

    private String afinacao;

}