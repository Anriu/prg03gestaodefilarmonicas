
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
@Table(name = "tb_calca")
@Data
@EqualsAndHashCode(callSuper = true)
public class Calca extends PersistenceEntity {

    private int tamanho;

}
