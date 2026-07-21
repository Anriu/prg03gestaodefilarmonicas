package br.com.ifba.material.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estantes")
@Getter 
@Setter 
@NoArgsConstructor
public class Estante extends PersistenceEntity {

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "observacoes")
    private String observacoes;
}