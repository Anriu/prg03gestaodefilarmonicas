package br.com.ifba.pessoa.entity;

import br.com.ifba.fardamento.entity.Farda;
import br.com.ifba.instrumento.entity.Instrumento;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
    
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farda_id")
    private Farda farda;
    
    //Clases que ainda serão implementadas mas entrarão como atributos
    //Estante 
    //Partituras
}
