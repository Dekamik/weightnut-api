/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.vonbargen.dennis.weightnut.api.model;

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
 * @author dennis
 */
@Entity
@Table(name = "system_parameter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemParameter.findAll", query = "SELECT s FROM SystemParameter s"),
    @NamedQuery(name = "SystemParameter.findByIdparam", query = "SELECT s FROM SystemParameter s WHERE s.idparam = :idparam"),
    @NamedQuery(name = "SystemParameter.findByParam", query = "SELECT s FROM SystemParameter s WHERE s.param = :param"),
    @NamedQuery(name = "SystemParameter.findByValue", query = "SELECT s FROM SystemParameter s WHERE s.value = :value")})
public class SystemParameter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idparam")
    private Long idparam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "param")
    private String param;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "value")
    private String value;

    public SystemParameter() {
    }

    public SystemParameter(Long idparam) {
        this.idparam = idparam;
    }

    public SystemParameter(Long idparam, String param, String value) {
        this.idparam = idparam;
        this.param = param;
        this.value = value;
    }

    public Long getIdparam() {
        return idparam;
    }

    public void setIdparam(Long idparam) {
        this.idparam = idparam;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparam != null ? idparam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SystemParameter)) {
            return false;
        }
        SystemParameter other = (SystemParameter) object;
        if ((this.idparam == null && other.idparam != null) || (this.idparam != null && !this.idparam.equals(other.idparam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.vonbargen.dennis.weightnut.api.model.SystemParameter[ idparam=" + idparam + " ]";
    }
    
}
