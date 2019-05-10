/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gustavo
 */
@Entity
@Table(name = "LISTA_PRODUTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaProduto.findAll", query = "SELECT l FROM ListaProduto l"),
    @NamedQuery(name = "ListaProduto.findById", query = "SELECT l FROM ListaProduto l WHERE l.id = :id"),
    @NamedQuery(name = "ListaProduto.findByNome", query = "SELECT l FROM ListaProduto l WHERE l.nome = :nome"),
    @NamedQuery(name = "ListaProduto.findByIdUsuario", query = "SELECT l FROM ListaProduto l WHERE l.idUsuario = :idUsuario")})
public class ListaProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    private int idUsuario;

    public ListaProduto() {
    }

    public ListaProduto(Integer id) {
        this.id = id;
    }

    public ListaProduto(Integer id, String nome, int idUsuario) {
        this.id = id;
        this.nome = nome;
        this.idUsuario = idUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof ListaProduto)) {
            return false;
        }
        ListaProduto other = (ListaProduto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ListaProduto[ id=" + id + " ]";
    }
    
}
