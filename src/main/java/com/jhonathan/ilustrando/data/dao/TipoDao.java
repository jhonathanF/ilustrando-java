package com.jhonathan.ilustrando.data.dao;

import com.jhonathan.ilustrando.data.entidade.Tipo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jhonathan
 */
@Repository
public interface TipoDao extends JpaRepository<Tipo, Integer> {

    static final int TIPO_MENSAGEM_INFORMACAO = 3;
    static final int TIPO_MENSAGEM_AVISO = 4;
    static final int TIPO_MENSAGEM_ERRO = 5;

    List<Tipo> findByGrupo_Id(@Param("id") Integer id);

}
