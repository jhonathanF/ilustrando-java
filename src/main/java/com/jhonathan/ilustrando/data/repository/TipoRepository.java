package com.jhonathan.ilustrando.data.repository;

import com.jhonathan.ilustrando.data.entidade.Tipo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jhonathan
 */
@Repository
public interface TipoRepository extends CrudRepository<Tipo, Long> {

}
