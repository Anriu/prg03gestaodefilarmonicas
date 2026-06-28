
package br.com.ifba.fardamento.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import br.com.ifba.pessoa.entity.MusicoBanda;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author anriu
 */

@Entity
@Table(name = "tb_entrega_farda")
@Data
@EqualsAndHashCode(callSuper = true)
public class EntregaFarda extends PersistenceEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "musico_id")
    private MusicoBanda musico;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farda_id")
    private Farda farda;

    @Enumerated(EnumType.STRING)
    private StatusFarda status;

    private LocalDate dataEntrega;

    private LocalDate dataDevolucao;
}
