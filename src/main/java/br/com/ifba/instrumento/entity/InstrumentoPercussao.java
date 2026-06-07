package br.com.ifba.instrumento.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Representa os instrumentos pertencentes à família da percussão.
 *
 * @author anriu
 */
@Entity
@DiscriminatorValue("PERCUSSAO")
@Data
@EqualsAndHashCode(callSuper = true)
public class InstrumentoPercussao extends Instrumento {

    /**
     * Tipo de pele utilizada pelo instrumento.
     */
    private String tipoPele;

    /**
     * Tipo de baqueta utilizada pelo instrumento.
     */
    private String tipoBaqueta;
}