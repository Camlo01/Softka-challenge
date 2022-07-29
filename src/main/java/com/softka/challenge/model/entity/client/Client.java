package com.softka.challenge.model.entity.client;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Client")
    private Integer idClient;
    @Column(unique = true)
    private String email;
    private String password;
    private String name;
    @Column(name = "Client_Type")
    private ClientType type;
    @Column(name = "birth_Date")
    private Date birthDate;


    //Constructors

    public Client() {
    }

    public Client(Integer idClient, String email, String password, String name, ClientType type, Date birthDate) {
        this.idClient = idClient;
        this.email = email;
        this.password = password;
        this.name = name;
        this.type = type;
        this.birthDate = birthDate;
    }


    //Getters and setters


    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


}
