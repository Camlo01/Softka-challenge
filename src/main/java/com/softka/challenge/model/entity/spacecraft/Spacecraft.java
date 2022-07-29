package com.softka.challenge.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Spacecraft")
public class Spacecraft implements Serializable, SpacecraftBehaviors {

    @Id
    @GeneratedValue
    @Column(name = "id_Ship", unique = true, nullable = false)
    private Integer idShip;

    @Column(name = "name")
    private String name;

    @Column(name = "name")
    private Date startActivity;

    @Column(name = "name")
    private Date endActivity;

    @Column(name = "name")
    private String country;

    @Column(name = "name")
    private Boolean statusActive;

    @Column(name = "fuel")
    private List<String> fuel;


    // Constructors


    // Getters and Setters


}
