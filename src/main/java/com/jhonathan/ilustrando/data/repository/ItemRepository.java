package com.jhonathan.ilustrando.data.repository;

import com.jhonathan.ilustrando.data.entidade.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jhonathan
 */
@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

}
