/*
 * Copyright 2017 Nejm.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nejm
 */
@Entity
@Table(name = "DASHBOARD_STAT", catalog = "", schema = "TEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DashboardStat.findAll", query = "SELECT d FROM DashboardStat d")
    , @NamedQuery(name = "DashboardStat.findById", query = "SELECT d FROM DashboardStat d WHERE d.id = :id")
    , @NamedQuery(name = "DashboardStat.findByIdDashboard", query = "SELECT d FROM DashboardStat d WHERE d.idDashboard = :idDashboard")
    , @NamedQuery(name = "DashboardStat.findByIdStat", query = "SELECT d FROM DashboardStat d WHERE d.idStat = :idStat")
    , @NamedQuery(name = "DashboardStat.findByText", query = "SELECT d FROM DashboardStat d WHERE d.text = :text")
    , @NamedQuery(name = "DashboardStat.findByTitle", query = "SELECT d FROM DashboardStat d WHERE d.title = :title")})
public class DashboardStat implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "ID_DASHBOARD")
    private Long idDashboard;
    @Column(name = "ID_STAT")
    private Long idStat;
    @Column(name = "TEXT")
    private String text;
    @Column(name = "TITLE")
    private String title;

    public DashboardStat() {
    }

    public DashboardStat(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDashboard() {
        return idDashboard;
    }

    public void setIdDashboard(Long idDashboard) {
        this.idDashboard = idDashboard;
    }

    public Long getIdStat() {
        return idStat;
    }

    public void setIdStat(Long idStat) {
        this.idStat = idStat;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        if (!(object instanceof DashboardStat)) {
            return false;
        }
        DashboardStat other = (DashboardStat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smi.model.DashboardStat[ id=" + id + " ]";
    }
    
}
