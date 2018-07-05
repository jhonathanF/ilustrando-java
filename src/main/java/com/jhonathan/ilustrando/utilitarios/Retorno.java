package com.jhonathan.ilustrando.utilitarios;

import com.jhonathan.ilustrando.data.dao.TipoDao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jhonathan
 */
public class Retorno {

    private Boolean valido = true;
    private List<Mensagem> mensagens = new ArrayList<>();
    private Object retorno;
    @Autowired
    private TipoDao tipoDao;

    public void inserirMensagemInformacao(String mensagem) {
        Mensagem msg = new Mensagem();
        msg.setTipoMensagem(tipoDao.findById(TipoDao.TIPO_MENSAGEM_INFORMACAO).get());
        msg.setMensagem(mensagem);
        this.mensagens.add(msg);
    }

    public void inserirMensagemAviso(String mensagem) {
        Mensagem msg = new Mensagem();
        msg.setTipoMensagem(tipoDao.findById(TipoDao.TIPO_MENSAGEM_AVISO).get());
        msg.setMensagem(mensagem);
        this.mensagens.add(msg);
    }

    public void inserirMensagemErro(String mensagem) {
        Mensagem msg = new Mensagem();
        msg.setTipoMensagem(tipoDao.findById(TipoDao.TIPO_MENSAGEM_ERRO).get());
        msg.setMensagem(mensagem);
        this.mensagens.add(msg);
    }

    public Boolean getValido() {
        return valido;
    }

    public void setValido(Boolean valido) {
        this.valido = valido;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public Object getRetorno() {
        return retorno;
    }

    public void setRetorno(Object retorno) {
        this.retorno = retorno;
    }

}
