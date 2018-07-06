package com.jhonathan.ilustrando.controllers;

import com.google.gson.Gson;
import com.jhonathan.ilustrando.data.entidade.Usuario;
import com.jhonathan.ilustrando.models.UsuarioBO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jhonathan
 */
@Controller
@RequestMapping(path = "/usuarioBo", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {

    @Autowired
    private UsuarioBO usuarioBo;
    private String retorno = "";
    private Gson gson = new Gson();

    @GetMapping(path = "/all")
    public @ResponseBody
    String getAllUsuario() {
        try {
            List<Usuario> u = usuarioBo.getlistUsuario();
            if (u != null) {
                retorno = gson.toJson(u);
            } else {
                retorno = "Nenhuma Usuario Localizada!";
            }
        } catch (Exception e) {
            retorno = "Erro ao localizar Usuarios";
        }
        return gson.toJson(retorno);
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    String getUsuario(@PathVariable("id") Integer id) {
        Optional<Usuario> u = null;

        try {
            u = usuarioBo.getUsuario(id);
        } catch (Exception e) {
            retorno = "Erro ao localizar Usuario";
        }
        if (u != null) {
            retorno = gson.toJson(u.get());
        }

        return retorno;

    }

    @PostMapping(path = "/inserir-usuario")
    public @ResponseBody
    String setUsuario(@RequestBody Usuario categoria) {
        try {
            Usuario u = usuarioBo.setUsuario(categoria);
            if (u != null) {
                retorno = gson.toJson(u);
            } else {
                retorno = "Usuario não inserida!";
            }
        } catch (Exception e) {
            retorno = "Erro ao Inserir Usuario";
        }
        return gson.toJson(retorno);

    }
}
