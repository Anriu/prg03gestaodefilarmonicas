package br.com.ifba.instrumento.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Representa os instrumentos pertencentes à família das madeiras.
 *
 * @author anriu
 */
@Entity
@DiscriminatorValue("MADEIRA")
@Data
@EqualsAndHashCode(callSuper = true)
public class InstrumentoMadeira extends InstrumentoSopro {

    /**
     * Tipo de palheta utilizada pelo instrumento.
     */
    private String tipoPalheta;
}