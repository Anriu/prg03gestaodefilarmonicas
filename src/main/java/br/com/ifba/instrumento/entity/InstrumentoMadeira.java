package br.com.ifba.instrumento.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("MADEIRA") // Valor que será salvo na coluna 'tipo_instrumento'
@Data
@EqualsAndHashCode(callSuper = true)
public class InstrumentoMadeira extends InstrumentoSopro {
    
    // Atributos específicos de madeira (ex: tipo de palheta)
    private String tipoPalheta; 
}