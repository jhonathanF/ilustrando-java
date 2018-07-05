package com.jhonathan.ilustrando.controllers;

import com.google.gson.Gson;
import com.jhonathan.ilustrando.data.entidade.Pessoa;
import com.jhonathan.ilustrando.models.PessoaBO;
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
@RequestMapping(path = "/pessoa", produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaController {

    @Autowired
    private PessoaBO pessoaBo;
    private String retorno = "";
    private Gson gson = new Gson();

    @GetMapping(path = "/all")
    public @ResponseBody
    String getAllPessoa() {
        try {
            List<Pessoa> p = pessoaBo.getlistPessoas();
            if (p != null) {
                retorno = gson.toJson(p);
            } else {
                retorno = "Nenhuma Pessoa Localizada!";
            }
        } catch (Exception e) {
            retorno = "Erro ao localizar Pessoas";
        }
        return gson.toJson(retorno);
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    String getPessoa(@PathVariable("id") Integer id) {
        Optional<Pessoa> p = null;

        try {
            p = pessoaBo.getPessoa(id);
        } catch (Exception e) {
            retorno = "Erro ao localizar Pessoa";
        }
        if (p != null) {
            retorno = gson.toJson(p.get());
        }

        return retorno;

    }

    @PostMapping(path = "/inserir-pessoa")
    public @ResponseBody
    String setPessoa(@RequestBody Pessoa pessoa) {
        try {
            Pessoa p = pessoaBo.setPessoa(pessoa);
            if (p != null) {
                retorno = gson.toJson(p);
            } else {
                retorno = "Pessoa não inserida!";
            }
        } catch (Exception e) {
            retorno = "Erro ao Inserir Pessoa";
        }
        return gson.toJson(retorno);

    }
}
