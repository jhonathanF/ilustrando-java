package com.jhonathan.ilustrando.data.dao;

import com.jhonathan.ilustrando.data.entidade.TransacaoEntrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jhonathan
 */
@Repository
public interface TransacaoEntradaDao extends JpaRepository<TransacaoEntrada, Integer> {

    
}
