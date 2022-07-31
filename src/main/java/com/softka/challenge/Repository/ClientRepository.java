package com.softka.challenge.Repository;

import com.softka.challenge.model.entity.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClientRepository {

    @Autowired
    private ClientInterface database;

    public Client save(Client client){
        return database.save(client);
    }

    public Optional<Client> getClientByKeyClient(String key){
        return database.findClientByKeyClient(key);
    }

    public Optional<Client> getClientByEmail(String email) {
        return database.findClientByEmail(email);
    }

    public List<Client> getAllClients() {
        return database.findAll();
    }

}
