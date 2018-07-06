/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhonathan.ilustrando.models;

import com.jhonathan.ilustrando.data.dao.UsuarioDao;
import com.jhonathan.ilustrando.data.entidade.Usuario;
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
public class UsuarioBO {
    
    @Autowired
    private UsuarioDao usuarioDao;

    public List<Usuario> getlistUsuario() {
        return usuarioDao.findAll();
    }

    public Optional<Usuario> getUsuario(Integer id) {
        return usuarioDao.findById(id);
    }

    @Transactional
    public Usuario setUsuario(Usuario c) {
        return usuarioDao.save(c);
    }
}
