package br.com.ifba.instrumento.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Representa os instrumentos pertencentes à família da percussão.
 *
 * @author anriu
 */
@Entity
@Table(name = "tb_instrumento_percussao")
@Data
@EqualsAndHashCode(callSuper = true)
public class InstrumentoPercussao extends Instrumento {

    private String tipoPele;

    private String tipoBaqueta;

}