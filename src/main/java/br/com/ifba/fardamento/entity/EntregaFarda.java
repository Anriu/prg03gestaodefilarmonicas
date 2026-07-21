package br.com.ifba.fardamento.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import br.com.ifba.pessoa.entity.MusicoBanda;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "entregas_farda")
@Getter 
@Setter
public class EntregaFarda extends PersistenceEntity {

    @ManyToOne
    @JoinColumn(name = "musico_id", nullable = false)
    private MusicoBanda musico; // Músico da banda que recebeu a farda[cite: 1]

    @Column(name = "data_entrega", nullable = false)
    private LocalDate dataEntrega;

    @Column(name = "data_devolucao_prevista")
    private LocalDate dataDevolucaoPrevista;

    @ManyToMany
    @JoinTable(
        name = "entrega_pecas",
        joinColumns = @JoinColumn(name = "entrega_id"),
        inverseJoinColumns = @JoinColumn(name = "peca_id")
    )
    private List<PecaFardamento> pecasEntregues;
}