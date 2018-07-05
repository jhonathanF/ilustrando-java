package com.jhonathan.ilustrando.utilitarios;

import com.jhonathan.ilustrando.data.entidade.Tipo;

/**
 *
 * @author jhonathan
 */
public class Mensagem {

    private Tipo tipoMensagem;
    private String mensagem;

    public Tipo getTipoMensagem() {
        return tipoMensagem;
    }

    public void setTipoMensagem(Tipo tipoMensagem) {
        this.tipoMensagem = tipoMensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
