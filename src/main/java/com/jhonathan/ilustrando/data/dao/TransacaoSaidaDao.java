package com.jhonathan.ilustrando.data.dao;

import com.jhonathan.ilustrando.data.entidade.TransacaoSaida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jhonathan
 */
@Repository
public interface TransacaoSaidaDao extends JpaRepository<TransacaoSaida, Integer> {

    
}
