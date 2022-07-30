package com.softka.challenge.Repository;

import com.softka.challenge.model.entity.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientInterface database;

    public Optional<Client> getClientByEmail(String email) {
        return database.findClientByEmail(email);
    }

    public List<Client> getAllClients() {
        return database.findAll();
    }

}
