package com.jhonathan.ilustrando.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jhonathan.ilustrando.data.entidade.Tipo;
import com.jhonathan.ilustrando.data.entidade.TipoGrupo;
import com.jhonathan.ilustrando.models.TipoBO;
import com.jhonathan.ilustrando.models.TipoGrupoBO;
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
@RequestMapping(path = "/tipo", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipoController {

    @Autowired
    private TipoBO tipoBo;
    @Autowired
    private TipoGrupoBO tipoGrupoBo;
    private String retorno = "";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GetMapping(path = "/all")
    public @ResponseBody
    String getAllPessoa() {
        try {
            List<Tipo> t = tipoBo.getlistTipo();
            if (t != null) {
                retorno = gson.toJson(t);
            } else {
                retorno = "Nenhuma Pessoa Localizada!";
            }
        } catch (Exception e) {
            retorno = "Erro ao localizar Pessoas";
        }
        return gson.toJson(retorno);
    }

    @GetMapping(path = "/por-grupo/{id}")
    public @ResponseBody
    String getPorGrupo(@PathVariable("id") Integer id) {
        try {
            List<Tipo> t = tipoBo.getlistTipoPorGrupo(id);
            if (t != null) {
                retorno = gson.toJson(t.get(0));
            } else {
                retorno = "Nenhuma Pessoa Localizada!";
            }
        } catch (Exception e) {
            retorno = "Erro ao localizar Categorias";
        }
        return gson.toJson(retorno);
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    String getPessoa(@PathVariable("id") Integer id) {
        try {
            Optional<Tipo> t = tipoBo.getTipo(id);
            if (t != null) {
                retorno = gson.toJson(t);
            } else {
                retorno = "Categoria Não Localizada!";
            }
        } catch (Exception e) {
            retorno = "Erro ao localizar Categoria";
        }
        return gson.toJson(retorno);

    }

    @PostMapping(path = "/inserir-tipo")
    public @ResponseBody
    String setTipo(@RequestBody List<Tipo> tipo) {
        try {
            for (Tipo t : tipo) {

                if (t.getGrupo() == null) {
                    Optional<TipoGrupo> grupo = tipoGrupoBo.getTipo(3);
                    if (grupo != null) {
                        t.setGrupo(grupo.get());
                    }
                }
                Tipo ti = tipoBo.setTipo(t);
                if (ti != null) {
                    retorno = gson.toJson(ti);
                } else {
                    retorno = "Tipo não inserida!";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gson.toJson(retorno);

    }
}
