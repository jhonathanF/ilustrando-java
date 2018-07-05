package com.jhonathan.ilustrando.data.dao;

import com.jhonathan.ilustrando.data.entidade.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jhonathan
 */
@Repository
public interface PessoaDao extends JpaRepository<Pessoa, Integer> {

    
}
