package br.com.ifba.instrumento.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Representa os instrumentos pertencentes à família das madeiras.
 *
 * @author anriu
 */
@Entity
@Table(name = "tb_instrumento_madeira")
@Data
@EqualsAndHashCode(callSuper = true)
public class InstrumentoMadeira extends InstrumentoSopro {

    private String tipoPalheta;

}