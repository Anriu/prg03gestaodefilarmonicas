package br.com.ifba.pessoa.entity;

import br.com.ifba.instrumento.entity.Instrumento;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author anriu
 */

@Entity
@Table(name = "tb_musico_banda")
@Data
@EqualsAndHashCode(callSuper = true)
public class MusicoBanda extends Aluno{
    
    
    private String naipe;
    
    @ManyToOne
    @JoinColumn(name = "instrumento_id")
    private Instrumento instrumento;
    
    //Clases que ainda serão implementadas mas entrarão como atributos
    //Estante 
    //Fardamento
    //Partituras
}
