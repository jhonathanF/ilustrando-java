package com.jhonathan.ilustrando.data.repository;

import com.jhonathan.ilustrando.data.entidade.PessoaEndereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jhonathan
 */
@Repository
public interface PessoaEnderecoRepository extends CrudRepository<PessoaEndereco, Long> {

}
