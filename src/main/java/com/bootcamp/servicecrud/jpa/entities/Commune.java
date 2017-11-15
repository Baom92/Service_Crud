/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.servicecrud.jpa.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Link;

/**
 *
 * @author Bello
 */
@Entity
@Table(name = "rest_commune")
@ApiModel(value="Commune",
	description="representation d'une signature Commune")
public class Commune implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value="Reference de la Commune", required=true)
    private int id;
    
    @NotNull(message="l'attribut nom doit etre renseigne")
    @Column(nullable = false, length = 30)
    @ApiModelProperty(value="nom de la commune", required=true)
    private String nom;
    
    @NotNull(message="l'attribut longitude doit etre renseigne")
    @Column(nullable = false, length = 50)
    @ApiModelProperty(value="longitude de la commune", required=true)
    private double longitude;
    
    @NotNull(message="l'attribut latitude doit etre renseigne")
    @Column(nullable = false, length = 50)
    @ApiModelProperty(value="latitude de la commune", required=true)
    private double latitude;
    
    @ManyToOne
    @JoinColumn(name = "departement", referencedColumnName = "id", insertable=false, updatable=false)
    Departement departement;
    
    //Introduction d'un lien propre à chaque entite, et comme entite personne est la mere de 3 autres
    //l'insertion se fera à son niveau
    @Transient
    private Link self; // utilisant l'API JAX-RS 2
    
    public Commune() {
    }
    
    public Commune(int id, String nom, double longitude, double latitude) {
        this.id = id;
        this.nom = nom;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    
    public Commune(String nom, double longitude, double latitude) {
        this.nom = nom;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public double getLongitude() {
        return longitude;
    }

    public void setLongitud(double longitude) {
        this.longitude = longitude;
    }
    
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    public Link getSelf() {
        return self;
    }

    public void setSelf(Link self) {
        this.self = self;
    }
    
    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement indicateur_performance) {
        this.departement = departement;
    }
}
