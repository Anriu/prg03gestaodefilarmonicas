package br.com.ifba.instrumento.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("SOPRO") // Valor que o Spring salvará na coluna 'tipo_instrumento'
@Data
@EqualsAndHashCode(callSuper = true)
public class InstrumentoSopro extends Instrumento {
    
    private String afinacao;
}