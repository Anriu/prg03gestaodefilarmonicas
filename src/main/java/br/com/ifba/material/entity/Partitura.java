package br.com.ifba.material.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import br.com.ifba.instrumento.entity.Instrumento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "partituras")
@Getter 
@Setter 
@NoArgsConstructor
public class Partitura extends PersistenceEntity {

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "arranjador")
    private String arranjador;

    @Column(name = "compositor")
    private String compositor;

    @Column(name = "estilo")
    private String estilo; // Ex: Dobrado, Marcha, Frevo

    @Column(name = "tipo_musical")
    private String tipoMusical;

    @ManyToMany
    @JoinTable(
        name = "partitura_instrumentos",
        joinColumns = @JoinColumn(name = "partitura_id"),
        inverseJoinColumns = @JoinColumn(name = "instrumento_id")
    )
    private List<Instrumento> instrumentos;
}