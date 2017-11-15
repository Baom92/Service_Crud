/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.servicecrud.jpa.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Link;

/**
 *
 * @author Bello
 */
@Entity
@Table(name = "rest_departement")
@ApiModel(value="Departement",
	description="representation d'une signature Departement")
public class Departement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value="Reference du Departement", required=true)
    private int id;
    
    @NotNull(message="l'attribut nom doit etre renseigne")
    @Column(nullable = false, length = 30)
    @ApiModelProperty(value="nom du departement", required=true)
    private String nom;
    
    @NotNull(message="l'attribut numero doit etre renseigne")
    @Column(nullable = false)
    @ApiModelProperty(value="numero du departement", required=true)
    private int numero;
    
    @NotNull(message="l'attribut longitude doit etre renseigne")
    @Column(nullable = false, length = 50)
    @ApiModelProperty(value="longitude du departement", required=true)
    private double longitude;
    
    @NotNull(message="l'attribut latitude doit etre renseigne")
    @Column(nullable = false, length = 50)
    @ApiModelProperty(value="latitude du departement", required=true)
    private double latitude;
    
    @OneToMany(mappedBy = "departement" , cascade = CascadeType.ALL)
    private List<Commune> communes;
    
    //Introduction d'un lien propre à chaque entite, et comme entite personne est la mere de 3 autres
    //l'insertion se fera à son niveau
    @Transient
    private Link self; // utilisant l'API JAX-RS 2
    
    public Departement() {
    }
    
    public Departement(int id, String nom, int numero, double longitude, double latitude) {
        this.id = id;
        this.nom = nom;
        this.numero = numero;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    
    public Departement(String nom, int numero, double longitude, double latitude) {
        this.nom = nom;
        this.numero = numero;
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
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    public List<Commune> getCommuneList() {
        return this.communes;
    }

    public void setCommuneList(List<Commune> communes) {
        this.communes = communes;
    }
    
    public Link getSelf() {
        return self;
    }

    public void setSelf(Link self) {
        this.self = self;
    }
}
