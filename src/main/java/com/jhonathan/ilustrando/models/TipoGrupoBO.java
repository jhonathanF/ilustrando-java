package com.jhonathan.ilustrando.models;

import com.jhonathan.ilustrando.data.dao.TipoGrupoDao;
import com.jhonathan.ilustrando.data.entidade.TipoGrupo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jhonathan
 */
@Service
public class TipoGrupoBO {

    @Autowired
    private TipoGrupoDao tipoGrupoDao;

    public List<TipoGrupo> getlistTipoGrupo() {
        return tipoGrupoDao.findAll();
    }

    public Optional<TipoGrupo> getTipo(Integer id) {
        return tipoGrupoDao.findById(id);
    }

    @Transactional
    public TipoGrupo setTipoGrupo(TipoGrupo p) {
        return tipoGrupoDao.save(p);
    }
}
