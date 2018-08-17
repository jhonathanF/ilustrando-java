package com.jhonathan.ilustrando.controllers;

import com.google.gson.Gson;
import com.jhonathan.ilustrando.data.entidade.Item;
import com.jhonathan.ilustrando.models.ItemBO;
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
@RequestMapping(path = "/item", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController {

    @Autowired
    private ItemBO itemBo;
    private String retorno = "";
    private Gson gson = new Gson();

    @GetMapping(path = "/all")
    public @ResponseBody
    String getAllItem() {
        try {
            List<Item> c = itemBo.getlistItem();
            if (c != null) {
                retorno = gson.toJson(c);
            } else {
                retorno = "Nenhuma Item Localizada!";
            }
        } catch (Exception e) {
            retorno = "Erro ao localizar Items";
        }
        return gson.toJson(retorno);
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    String getItem(@PathVariable("id") Integer id) {
        Optional<Item> i = null;

        try {
            i = itemBo.getItem(id);
        } catch (Exception e) {
            retorno = "Erro ao localizar Item";
        }
        if (i != null) {
            retorno = gson.toJson(i.get());
        }

        return retorno;

    }

    @PostMapping(path = "/inserir-item")
    public @ResponseBody
    String setItem(@RequestBody Item item) {
        try {
            Item i = itemBo.setItem(item);
            if (i != null) {
                retorno = gson.toJson(i);
            } else {
                retorno = "Item não inserida!";
            }
        } catch (Exception e) {
            retorno = "Erro ao Inserir Item";
        }
        return gson.toJson(retorno);

    }
}
