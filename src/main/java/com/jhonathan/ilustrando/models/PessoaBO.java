package com.jhonathan.ilustrando.models;

import com.jhonathan.ilustrando.data.dao.PessoaDao;
import com.jhonathan.ilustrando.data.entidade.Pessoa;
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
public class PessoaBO {

    @Autowired
    private PessoaDao pessoaDao;

    public List<Pessoa> getlistPessoas() {
        return pessoaDao.findAll();
    }

    public Optional<Pessoa> getPessoa(Integer id) {
        return pessoaDao.findById(id);
    }

    @Transactional
    public Pessoa setPessoa(Pessoa p) {
        return pessoaDao.save(p);
    }
}
