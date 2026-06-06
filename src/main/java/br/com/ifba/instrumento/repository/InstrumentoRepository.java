package br.com.ifba.instrumento.repository;

import br.com.ifba.instrumento.entity.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository responsável pelas operações de CRUD de Instrumento no Supabase.
 * * @author anriu
 */
@Repository
public interface InstrumentoRepository extends JpaRepository<Instrumento, Long> {
}