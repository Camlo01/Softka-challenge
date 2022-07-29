package com.softka.challenge.model.entity.spacecraft;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Year;
import java.util.Date;

@Entity
@Table(name = "spacecraft")
public class Spacecraft implements Serializable, SpacecraftBehaviors {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
//    @Column(name = "idShip", unique = true, nullable = false)
    private Integer idShip;
    private String name;
    private Integer startActivity;
    private Integer endActivity;
    private String country;
    private Boolean statusActive;
    private String manufacturer;
    private String description;

    // Constructors


    public Spacecraft() {
    }

    public Spacecraft(String name) {
        this.name = name;
    }

    public Spacecraft(Integer idShip, String name, Integer startActivity, Integer endActivity, String country, Boolean statusActive, String manufacturer, String description) {
        this.idShip = idShip;
        this.name = name;
        this.startActivity = startActivity;
        this.endActivity = endActivity;
        this.country = country;
        this.statusActive = statusActive;
        this.manufacturer = manufacturer;
        this.description = description;
    }

    // Getters and Setters

    public Integer getIdShip() {
        return idShip;
    }

    public void setIdShip(Integer idShip) {
        this.idShip = idShip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStartActivity() {
        return startActivity;
    }

    public void setStartActivity(Integer startActivity) {
        this.startActivity = startActivity;
    }

    public Integer getEndActivity() {
        return endActivity;
    }

    public void setEndActivity(Integer endActivity) {
        this.endActivity = endActivity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getStatusActive() {
        return statusActive;
    }

    public void setStatusActive(Boolean statusActive) {
        this.statusActive = statusActive;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    //OverrideMethods


}
