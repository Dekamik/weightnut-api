/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.vonbargen.dennis.weightnut.api.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dennis
 */
@Entity
@Table(name = "meal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meal.findAll", query = "SELECT m FROM Meal m"),
    @NamedQuery(name = "Meal.findByIdmeal", query = "SELECT m FROM Meal m WHERE m.idmeal = :idmeal"),
    @NamedQuery(name = "Meal.findByMealName", query = "SELECT m FROM Meal m WHERE m.mealName = :mealName")})
public class Meal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmeal")
    private Long idmeal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "meal_name")
    private String mealName;
    @JoinTable(name = "ingredient", joinColumns = {
        @JoinColumn(name = "idmeal", referencedColumnName = "idmeal")}, inverseJoinColumns = {
        @JoinColumn(name = "idfood", referencedColumnName = "idfood")})
    @ManyToMany
    private Collection<Food> foodCollection;

    public Meal() {
    }

    public Meal(Long idmeal) {
        this.idmeal = idmeal;
    }

    public Meal(Long idmeal, String mealName) {
        this.idmeal = idmeal;
        this.mealName = mealName;
    }

    public Long getIdmeal() {
        return idmeal;
    }

    public void setIdmeal(Long idmeal) {
        this.idmeal = idmeal;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    @XmlTransient
    public Collection<Food> getFoodCollection() {
        return foodCollection;
    }

    public void setFoodCollection(Collection<Food> foodCollection) {
        this.foodCollection = foodCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmeal != null ? idmeal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meal)) {
            return false;
        }
        Meal other = (Meal) object;
        if ((this.idmeal == null && other.idmeal != null) || (this.idmeal != null && !this.idmeal.equals(other.idmeal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.vonbargen.dennis.weightnut.api.model.Meal[ idmeal=" + idmeal + " ]";
    }
    
}
