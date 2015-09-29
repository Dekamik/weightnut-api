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
@Table(name = "food")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Food.findAll", query = "SELECT f FROM Food f"),
    @NamedQuery(name = "Food.findByIdfood", query = "SELECT f FROM Food f WHERE f.idfood = :idfood"),
    @NamedQuery(name = "Food.findByName", query = "SELECT f FROM Food f WHERE f.name = :name"),
    @NamedQuery(name = "Food.findByEnergyKcal", query = "SELECT f FROM Food f WHERE f.energyKcal = :energyKcal"),
    @NamedQuery(name = "Food.findByEnergykJ", query = "SELECT f FROM Food f WHERE f.energykJ = :energykJ"),
    @NamedQuery(name = "Food.findByCarbsG", query = "SELECT f FROM Food f WHERE f.carbsG = :carbsG"),
    @NamedQuery(name = "Food.findByFatG", query = "SELECT f FROM Food f WHERE f.fatG = :fatG"),
    @NamedQuery(name = "Food.findByProteinG", query = "SELECT f FROM Food f WHERE f.proteinG = :proteinG"),
    @NamedQuery(name = "Food.findByFiberG", query = "SELECT f FROM Food f WHERE f.fiberG = :fiberG"),
    @NamedQuery(name = "Food.findByWaterG", query = "SELECT f FROM Food f WHERE f.waterG = :waterG"),
    @NamedQuery(name = "Food.findByAlcoholG", query = "SELECT f FROM Food f WHERE f.alcoholG = :alcoholG")})
public class Food implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfood")
    private Long idfood;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "energy_kcal")
    private double energyKcal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "energy_kJ")
    private Double energykJ;
    @Column(name = "carbs_g")
    private Double carbsG;
    @Column(name = "fat_g")
    private Double fatG;
    @Column(name = "protein_g")
    private Double proteinG;
    @Column(name = "fiber_g")
    private Double fiberG;
    @Column(name = "water_g")
    private Double waterG;
    @Column(name = "alcohol_g")
    private Double alcoholG;
    @ManyToMany(mappedBy = "foodCollection")
    private Collection<Meal> mealCollection;

    public Food() {
    }

    public Food(Long idfood) {
        this.idfood = idfood;
    }

    public Food(Long idfood, String name, double energyKcal) {
        this.idfood = idfood;
        this.name = name;
        this.energyKcal = energyKcal;
    }

    public Long getIdfood() {
        return idfood;
    }

    public void setIdfood(Long idfood) {
        this.idfood = idfood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEnergyKcal() {
        return energyKcal;
    }

    public void setEnergyKcal(double energyKcal) {
        this.energyKcal = energyKcal;
    }

    public Double getEnergykJ() {
        return energykJ;
    }

    public void setEnergykJ(Double energykJ) {
        this.energykJ = energykJ;
    }

    public Double getCarbsG() {
        return carbsG;
    }

    public void setCarbsG(Double carbsG) {
        this.carbsG = carbsG;
    }

    public Double getFatG() {
        return fatG;
    }

    public void setFatG(Double fatG) {
        this.fatG = fatG;
    }

    public Double getProteinG() {
        return proteinG;
    }

    public void setProteinG(Double proteinG) {
        this.proteinG = proteinG;
    }

    public Double getFiberG() {
        return fiberG;
    }

    public void setFiberG(Double fiberG) {
        this.fiberG = fiberG;
    }

    public Double getWaterG() {
        return waterG;
    }

    public void setWaterG(Double waterG) {
        this.waterG = waterG;
    }

    public Double getAlcoholG() {
        return alcoholG;
    }

    public void setAlcoholG(Double alcoholG) {
        this.alcoholG = alcoholG;
    }

    @XmlTransient
    public Collection<Meal> getMealCollection() {
        return mealCollection;
    }

    public void setMealCollection(Collection<Meal> mealCollection) {
        this.mealCollection = mealCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfood != null ? idfood.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Food)) {
            return false;
        }
        Food other = (Food) object;
        if ((this.idfood == null && other.idfood != null) || (this.idfood != null && !this.idfood.equals(other.idfood))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.vonbargen.dennis.weightnut.api.model.Food[ idfood=" + idfood + " ]";
    }
    
}
