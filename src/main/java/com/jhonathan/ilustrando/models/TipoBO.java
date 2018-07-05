package com.jhonathan.ilustrando.models;

import com.jhonathan.ilustrando.data.dao.TipoDao;
import com.jhonathan.ilustrando.data.entidade.Tipo;
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
public class TipoBO {

    @Autowired
    private TipoDao tipoDao;

    public List<Tipo> getlistTipo() {
        return tipoDao.findAll();
    }

    public List<Tipo> getlistTipoPorGrupo(Integer id) {
        return tipoDao.findByGrupo_Id(id);
    }

    public Optional<Tipo> getTipo(Integer id) {
        return tipoDao.findById(id);
    }

    @Transactional
    public Tipo setTipo(Tipo p) {
        return tipoDao.save(p);
    }
}
