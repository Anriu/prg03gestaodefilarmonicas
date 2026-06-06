package br.com.ifba.instrumento.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("MADEIRA") // Identificador no banco de dados
@Data
@EqualsAndHashCode(callSuper = true)
public class InstrumentoMadeira extends InstrumentoSopro {

    private boolean possuiPalheta;

    @OneToOne // Mapeia o relacionamento de associação do UML
    @JoinColumn(name = "palheta_id", referencedColumnName = "id") // Cria a chave estrangeira no banco
    private Palheta palheta;
}