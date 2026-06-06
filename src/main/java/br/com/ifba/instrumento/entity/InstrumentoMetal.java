package br.com.ifba.instrumento.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("METAL") // Identificador no banco de dados
@Data
@EqualsAndHashCode(callSuper = true)
public class InstrumentoMetal extends InstrumentoSopro {

    private String tipoValvula;
    private String modeloBocal;
    private boolean pisto;
    private int quantidadePisto;
    private boolean slide;
}