/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Utilizador
 */
@Entity
@Table(name = "PRODUTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")
    , @NamedQuery(name = "Produto.findByProdid", query = "SELECT p FROM Produto p WHERE p.prodid = :prodid")
    , @NamedQuery(name = "Produto.findByNome", query = "SELECT p FROM Produto p WHERE p.nome = :nome")
    , @NamedQuery(name = "Produto.findByStock", query = "SELECT p FROM Produto p WHERE p.stock = :stock")
    , @NamedQuery(name = "Produto.findByPreco", query = "SELECT p FROM Produto p WHERE p.preco = :preco")
    , @NamedQuery(name = "Produto.findByCategoria", query = "SELECT p FROM Produto p WHERE p.categoria = :categoria")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODID")
    private Integer prodid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOME")
    private String nome;
    @Column(name = "STOCK")
    private Integer stock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECO")
    private double preco;
    @Size(max = 50)
    @Column(name = "CATEGORIA")
    private String categoria;
    @JoinColumn(name = "VENDID", referencedColumnName = "NOME")
    @ManyToOne
    private Vendedor vendid;

    public Produto() {
    }

    public Produto(Integer prodid) {
        this.prodid = prodid;
    }

    public Produto(Integer prodid, String nome, double preco) {
        this.prodid = prodid;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getProdid() {
        return prodid;
    }

    public void setProdid(Integer prodid) {
        this.prodid = prodid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Vendedor getVendid() {
        return vendid;
    }

    public void setVendid(Vendedor vendid) {
        this.vendid = vendid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodid != null ? prodid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.prodid == null && other.prodid != null) || (this.prodid != null && !this.prodid.equals(other.prodid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Produto[ prodid=" + prodid + " ]";
    }
    
}
