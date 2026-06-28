package br.com.ifba.pessoa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author anriu
 */

@Entity
@Table(name = "tb_maestro")
@Data
@EqualsAndHashCode(callSuper = true)
public class Maestro extends Aluno{
    
    private String contrato;
    private double salario;
    
}
