package com.jhonathan.ilustrando.models;

import com.jhonathan.ilustrando.data.dao.CategoriaDao;
import com.jhonathan.ilustrando.data.entidade.Categoria;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jhonathan
 */
public class CategoriaBO {

    @Autowired
    private CategoriaDao categoriaDao;

    public List<Categoria> getlistCategoria() {
        return categoriaDao.findAll();
    }

    public Optional<Categoria> getCategoria(Integer id) {
        return categoriaDao.findById(id);
    }

    @Transactional
    public Categoria setPessoa(Categoria c) {
        return categoriaDao.save(c);
    }
}
