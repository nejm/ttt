/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smi.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Generated;

/**
 *
 * @author Nejm
 */
@Entity
@Table(name = "CODE_VERIF", catalog = "", schema = "TEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodeVerif.findAll", query = "SELECT c FROM CodeVerif c")
    , @NamedQuery(name = "CodeVerif.findByCodeProduitService", query = "SELECT c FROM CodeVerif c WHERE c.codeProduitService = :codeProduitService")
    , @NamedQuery(name = "CodeVerif.findByCodeOperation", query = "SELECT c FROM CodeVerif c WHERE c.codeOperation = :codeOperation")
    , @NamedQuery(name = "CodeVerif.findByDateOperation", query = "SELECT c FROM CodeVerif c WHERE c.dateOperation = :dateOperation")
    , @NamedQuery(name = "CodeVerif.findByRefOperation", query = "SELECT c FROM CodeVerif c WHERE c.refOperation = :refOperation")
    , @NamedQuery(name = "CodeVerif.findByKeyCode", query = "SELECT c FROM CodeVerif c WHERE c.keyCode = :keyCode")
    , @NamedQuery(name = "CodeVerif.findByDateGen", query = "SELECT c FROM CodeVerif c WHERE c.dateGen = :dateGen")
    , @NamedQuery(name = "CodeVerif.findByDateFin", query = "SELECT c FROM CodeVerif c WHERE c.dateFin = :dateFin")
    , @NamedQuery(name = "CodeVerif.findByIdCode", query = "SELECT c FROM CodeVerif c WHERE c.idCode = :idCode")})
public class CodeVerif implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CODE_PRODUIT_SERVICE")
    private Integer codeProduitService;
    @Column(name = "CODE_OPERATION")
    private Short codeOperation;
    @Column(name = "DATE_OPERATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOperation;
    @Column(name = "REF_OPERATION")
    private Long refOperation;
    @Size(max = 20)
    @Column(name = "KEY_CODE")
    private String keyCode;
    @Column(name = "DATE_GEN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateGen;
    @Column(name = "DATE_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CODE")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCode;

    public CodeVerif() {
    }

    public CodeVerif(Long idCode) {
        this.idCode = idCode;
    }

    public Integer getCodeProduitService() {
        return codeProduitService;
    }

    public void setCodeProduitService(Integer codeProduitService) {
        this.codeProduitService = codeProduitService;
    }

    public Short getCodeOperation() {
        return codeOperation;
    }

    public void setCodeOperation(Short codeOperation) {
        this.codeOperation = codeOperation;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public Long getRefOperation() {
        return refOperation;
    }

    public void setRefOperation(Long refOperation) {
        this.refOperation = refOperation;
    }

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    public Date getDateGen() {
        return dateGen;
    }

    public void setDateGen(Date dateGen) {
        this.dateGen = dateGen;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Long getIdCode() {
        return idCode;
    }

    public void setIdCode(Long idCode) {
        this.idCode = idCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCode != null ? idCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodeVerif)) {
            return false;
        }
        CodeVerif other = (CodeVerif) object;
        if ((this.idCode == null && other.idCode != null) || (this.idCode != null && !this.idCode.equals(other.idCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smi.model.CodeVerif[ idCode=" + idCode + " ]";
    }
    
}
