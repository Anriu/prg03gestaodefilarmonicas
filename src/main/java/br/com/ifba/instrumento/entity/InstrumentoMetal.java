package br.com.ifba.instrumento.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Representa os instrumentos pertencentes à família dos metais.
 *
 * @author anriu
 */
@Table(name = "tb_instrumento_metal")
@Data
@EqualsAndHashCode(callSuper = true)
public class InstrumentoMetal extends InstrumentoSopro {

    private Integer qtdPistoes;

    private boolean possuiRotor;

}