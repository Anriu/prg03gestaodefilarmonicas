package br.com.ifba.fardamento.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Representa uma farda completa da filarmônica.
 *
 * @author anriu
 */
@Entity
@Table(name = "tb_farda")
@Data
@EqualsAndHashCode(callSuper = true)
public class Farda extends PersistenceEntity {

    @Enumerated(EnumType.STRING)
    private TipoFarda tipo;

    @OneToOne
    @JoinColumn(name = "blusa_id")
    private Blusa blusa;

    @OneToOne
    @JoinColumn(name = "blase_id")
    private Blase blase;

    @OneToOne
    @JoinColumn(name = "gravata_id")
    private Gravata gravata;

    @OneToOne
    @JoinColumn(name = "talaba_id")
    private Cordao cordao;

    @OneToOne
    @JoinColumn(name = "quepe_id")
    private Quepe quepe;

    @OneToOne
    @JoinColumn(name = "calca_id")
    private Calca calca;

    @OneToOne
    @JoinColumn(name = "saia_id")
    private Saia saia;

}