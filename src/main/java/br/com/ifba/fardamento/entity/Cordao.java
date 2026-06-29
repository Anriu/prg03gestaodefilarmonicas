package br.com.ifba.fardamento.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author anriu
 */

@Entity
@Table(name = "tb_talaba")
@Data
@EqualsAndHashCode(callSuper = true)
public class Cordao extends PersistenceEntity {

}