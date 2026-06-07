package br.com.ifba.instrumento.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Representa os instrumentos pertencentes à família dos metais.
 *
 * @author anriu
 */
@Entity
@DiscriminatorValue("METAL")
@Data
@EqualsAndHashCode(callSuper = true)
public class InstrumentoMetal extends InstrumentoSopro {

    /**
     * Quantidade de pistões ou válvulas presentes no instrumento.
     */
    private Integer qtdPistoes;
}