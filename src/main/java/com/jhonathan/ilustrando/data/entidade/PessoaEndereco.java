/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhonathan.ilustrando.data.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhonathan
 */
@Entity
@Table(name = "pessoa_endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaEndereco.findAll", query = "SELECT p FROM PessoaEndereco p")
    , @NamedQuery(name = "PessoaEndereco.findById", query = "SELECT p FROM PessoaEndereco p WHERE p.id = :id")
    , @NamedQuery(name = "PessoaEndereco.findByCep", query = "SELECT p FROM PessoaEndereco p WHERE p.cep = :cep")
    , @NamedQuery(name = "PessoaEndereco.findByLogradouro", query = "SELECT p FROM PessoaEndereco p WHERE p.logradouro = :logradouro")
    , @NamedQuery(name = "PessoaEndereco.findByNumero", query = "SELECT p FROM PessoaEndereco p WHERE p.numero = :numero")
    , @NamedQuery(name = "PessoaEndereco.findByCidade", query = "SELECT p FROM PessoaEndereco p WHERE p.cidade = :cidade")
    , @NamedQuery(name = "PessoaEndereco.findByBairro", query = "SELECT p FROM PessoaEndereco p WHERE p.bairro = :bairro")
    , @NamedQuery(name = "PessoaEndereco.findByUf", query = "SELECT p FROM PessoaEndereco p WHERE p.uf = :uf")
    , @NamedQuery(name = "PessoaEndereco.findByComplemento", query = "SELECT p FROM PessoaEndereco p WHERE p.complemento = :complemento")})
public class PessoaEndereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cep")
    private int cep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "logradouro")
    private String logradouro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "UF")
    private String uf;
    @Size(max = 45)
    @Column(name = "complemento")
    private String complemento;

    public PessoaEndereco() {
    }

    public PessoaEndereco(Integer id) {
        this.id = id;
    }

    public PessoaEndereco(Integer id, int cep, String logradouro, int numero, String cidade, String bairro, String uf) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.bairro = bairro;
        this.uf = uf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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
        if (!(object instanceof PessoaEndereco)) {
            return false;
        }
        PessoaEndereco other = (PessoaEndereco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jhonathan.ilustrando.data.entidade.PessoaEndereco[ id=" + id + " ]";
    }
    
}
