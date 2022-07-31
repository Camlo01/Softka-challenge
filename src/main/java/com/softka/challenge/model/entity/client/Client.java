package com.softka.challenge.model.entity.client;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Integer idClient;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "type", columnDefinition = "ENUM('CLIENT', 'ADMIN'")
    @Enumerated(EnumType.STRING)
    private ClientType type;
    @Column(name = "keyclient", unique = true)
    private String keyClient;


    //Constructors

    public Client() {
    }

    public Client(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public Client(Integer idClient, String email, String password, String name, ClientType type, String keyClient) {
        this.idClient = idClient;
        this.email = email;
        this.password = password;
        this.name = name;
        this.type = type;
        this.keyClient = new Keyclient().generateKeyClient();
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

    public String getKeyClient() {
        return keyClient;
    }

    public void setKeyClient(String keyClient) {
        this.keyClient = keyClient;
    }
}
