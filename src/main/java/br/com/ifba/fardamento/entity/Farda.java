package br.com.ifba.fardamento.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "fardas")
@Getter 
@Setter
public class Farda extends PersistenceEntity {

    @Column(name = "nome_conjunto", nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_farda")
    private TipoFarda tipoFarda; 

    
    @ManyToMany
    @JoinTable(
        name = "farda_pecas",
        joinColumns = @JoinColumn(name = "farda_id"),
        inverseJoinColumns = @JoinColumn(name = "peca_fardamento_id")
    )
    private List<PecaFardamento> pecas;
}