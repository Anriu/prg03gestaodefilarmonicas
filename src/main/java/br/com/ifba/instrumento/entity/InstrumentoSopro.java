package br.com.ifba.instrumento.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class InstrumentoSopro extends Instrumento {
    
    // Atributo herdado por todos os instrumentos de sopro (ex: "Si Bemol", "Dó", "Fá")
    private String afinacao;
}