package com.jhonathan.ilustrando.controllers;

import com.google.gson.Gson;
import com.jhonathan.ilustrando.data.entidade.Categoria;
import com.jhonathan.ilustrando.models.CategoriaBO;
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
@RequestMapping(path = "/categoria", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoriaController {

    @Autowired
    private CategoriaBO categoriaBo;
    private String retorno = "";
    private Gson gson = new Gson();

    @GetMapping(path = "/all")
    public @ResponseBody
    String getAllCategoria() {
        try {
            List<Categoria> c = categoriaBo.getlistCategoria();
            if (c != null) {
                retorno = gson.toJson(c);
            } else {
                retorno = "Nenhuma Categoria Localizada!";
            }
        } catch (Exception e) {
            retorno = "Erro ao localizar Categorias";
        }
        return gson.toJson(retorno);
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    String getCategoria(@PathVariable("id") Integer id) {
        Optional<Categoria> c = null;

        try {
            c = categoriaBo.getCategoria(id);
        } catch (Exception e) {
            retorno = "Erro ao localizar Categoria";
        }
        if (c != null) {
            retorno = gson.toJson(c.get());
        }

        return retorno;

    }

    @PostMapping(path = "/inserir-categoria")
    public @ResponseBody
    String setCategoria(@RequestBody Categoria categoria) {
        try {
            Categoria p = categoriaBo.setCategoria(categoria);
            if (p != null) {
                retorno = gson.toJson(p);
            } else {
                retorno = "Categoria não inserida!";
            }
        } catch (Exception e) {
            retorno = "Erro ao Inserir Categoria";
        }
        return gson.toJson(retorno);

    }
}
