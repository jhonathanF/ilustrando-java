/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhonathan.ilustrando.data.entidade;

import com.jhonathan.ilustrando.data.entidade.Pessoa;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhonathan
 */
@Entity
@Table(name = "transacao_entrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransacaoEntrada.findAll", query = "SELECT t FROM TransacaoEntrada t")
    , @NamedQuery(name = "TransacaoEntrada.findById", query = "SELECT t FROM TransacaoEntrada t WHERE t.id = :id")
    , @NamedQuery(name = "TransacaoEntrada.findByValor", query = "SELECT t FROM TransacaoEntrada t WHERE t.valor = :valor")
    , @NamedQuery(name = "TransacaoEntrada.findByDataLancamento", query = "SELECT t FROM TransacaoEntrada t WHERE t.dataLancamento = :dataLancamento")})
public class TransacaoEntrada implements Serializable {

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
    @Column(name = "data_lancamento")
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;
    @JoinColumn(name = "pessoa_contribuinte", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa pessoaContribuinte;

    public TransacaoEntrada() {
    }

    public TransacaoEntrada(Integer id) {
        this.id = id;
    }

    public TransacaoEntrada(Integer id, double valor, Date dataLancamento) {
        this.id = id;
        this.valor = valor;
        this.dataLancamento = dataLancamento;
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

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Pessoa getPessoaContribuinte() {
        return pessoaContribuinte;
    }

    public void setPessoaContribuinte(Pessoa pessoaContribuinte) {
        this.pessoaContribuinte = pessoaContribuinte;
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
        if (!(object instanceof TransacaoEntrada)) {
            return false;
        }
        TransacaoEntrada other = (TransacaoEntrada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jhonathan.ilustrando.data.entidade.TransacaoEntrada[ id=" + id + " ]";
    }
    
}
