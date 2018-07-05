/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhonathan.ilustrando.data.entidade;

import com.jhonathan.ilustrando.data.entidade.Item;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhonathan
 */
@Entity
@Table(name = "transacao_saida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransacaoSaida.findAll", query = "SELECT t FROM TransacaoSaida t")
    , @NamedQuery(name = "TransacaoSaida.findById", query = "SELECT t FROM TransacaoSaida t WHERE t.id = :id")
    , @NamedQuery(name = "TransacaoSaida.findByValor", query = "SELECT t FROM TransacaoSaida t WHERE t.valor = :valor")
    , @NamedQuery(name = "TransacaoSaida.findByQuantidade", query = "SELECT t FROM TransacaoSaida t WHERE t.quantidade = :quantidade")
    , @NamedQuery(name = "TransacaoSaida.findByObservacoes", query = "SELECT t FROM TransacaoSaida t WHERE t.observacoes = :observacoes")
    , @NamedQuery(name = "TransacaoSaida.findByDataLancamento", query = "SELECT t FROM TransacaoSaida t WHERE t.dataLancamento = :dataLancamento")})
public class TransacaoSaida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @Size(max = 250)
    @Column(name = "observacoes")
    private String observacoes;
    @Column(name = "data_lancamento")
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;
    @JoinColumn(name = "item", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Item item;

    public TransacaoSaida() {
    }

    public TransacaoSaida(Integer id) {
        this.id = id;
    }

    public TransacaoSaida(Integer id, double valor, int quantidade) {
        this.id = id;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransacaoSaida)) {
            return false;
        }
        TransacaoSaida other = (TransacaoSaida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jhonathan.ilustrando.data.entidade.TransacaoSaida[ id=" + id + " ]";
    }
    
}
