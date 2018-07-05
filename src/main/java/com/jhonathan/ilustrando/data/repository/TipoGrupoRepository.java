package com.jhonathan.ilustrando.data.repository;

import com.jhonathan.ilustrando.data.entidade.TipoGrupo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jhonathan
 */
@Repository
public interface TipoGrupoRepository extends CrudRepository<TipoGrupo, Long> {

}
