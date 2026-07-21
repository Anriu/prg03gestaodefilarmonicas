package br.com.ifba.fardamento.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pecas_fardamento")
@Getter 
@Setter 
@NoArgsConstructor
public class PecaFardamento extends PersistenceEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_peca", nullable = false)
    private TipoPecaFardamento tipoPeca;

    @Column(name = "tamanho", nullable = false)
    private String tamanho; 

    @Column(name = "quantidade_estoque")
    private Integer quantidadeEstoque;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_farda")
    private StatusFarda statusFarda; 

    @Column(name = "observacoes")
    private String observacoes;
}