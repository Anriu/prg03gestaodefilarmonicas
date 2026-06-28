package br.com.ifba.fardamento.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_blusa")
@Data
@EqualsAndHashCode(callSuper = true)
public class Blusa extends PersistenceEntity {

    private int tamanho;

}