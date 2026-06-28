package br.com.ifba.pessoa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 *
 * @author anriu
 */

@Entity
@Table(name = "tb_monitor")
@Data
@EqualsAndHashCode(callSuper = true)
public class Monitor extends MusicoBanda {

    @OneToMany(mappedBy = "monitor")
    private List<Aluno> alunos = new ArrayList<>();

    private double bolsa;
}