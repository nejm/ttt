package com.smi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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

@Entity
@Table(name = "ALIAS", catalog = "", schema = "TEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alias.findAll", query = "SELECT a FROM Alias a")
    , @NamedQuery(name = "Alias.findById", query = "SELECT a FROM Alias a WHERE a.id = :id")
    , @NamedQuery(name = "Alias.findByIdStat", query = "SELECT a FROM Alias a WHERE a.idStat = :idStat")
    , @NamedQuery(name = "Alias.findByName", query = "SELECT a FROM Alias a WHERE a.name = :name")})
public class Alias implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "ID_STAT")
    private Long idStat;
    @Column(name = "NAME")
    private String name;

    public Alias() {
    }

    public Alias(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdStat() {
        return idStat;
    }

    public void setIdStat(Long idStat) {
        this.idStat = idStat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof Alias)) {
            return false;
        }
        Alias other = (Alias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smi.model.Alias[ id=" + id + " ]";
    }

}
