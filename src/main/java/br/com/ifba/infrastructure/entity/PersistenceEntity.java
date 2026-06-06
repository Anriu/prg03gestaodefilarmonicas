package br.com.ifba.infrastructure.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author anriu
 */
@Getter
@Setter
@MappedSuperclass
public class PersistenceEntity {

    // ID único da entidade
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}