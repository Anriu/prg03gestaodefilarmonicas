package br.com.ifba.instrumento.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("METAL") // Valor que será salvo na coluna 'tipo_instrumento'
@Data
@EqualsAndHashCode(callSuper = true)
public class InstrumentoMetal extends InstrumentoSopro {
    
    // Atributos específicos de metal (ex: quantidade de pistões/válvulas)
    private Integer qtdPistoes;
}