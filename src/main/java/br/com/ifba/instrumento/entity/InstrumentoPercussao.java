package br.com.ifba.instrumento.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("PERCUSSAO") // Identificador no banco de dados
@Data
@EqualsAndHashCode(callSuper = true)
public class InstrumentoPercussao extends Instrumento {

    private String tipoPele;
    private String tipoBaqueta;
}