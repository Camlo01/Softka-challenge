package com.softka.challenge.services;

import com.softka.challenge.Repository.ClientRepository;
import com.softka.challenge.Repository.spacecraftRepository;
import com.softka.challenge.model.entity.client.Client;
import com.softka.challenge.model.entity.client.ClientType;
import com.softka.challenge.model.entity.client.Keyclient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientServices {

    @Autowired
    private ClientRepository repository;

    //GET
    public List<Client> getAllClients() {
        return repository.getAllClients();
    }


    public Client register(Client client){
        client.setKeyClient(new Keyclient().generateKeyClient());
        return repository.save(client);

    }

    // LOGIN
    public Optional<Client> login(Client clientToLogin) {

        Optional<Client> clientGetted = repository.getClientByEmail(clientToLogin.getEmail());


        boolean hasSameEmail = Objects.equals(clientGetted.get().getEmail(), clientToLogin.getEmail());
        boolean hasSamePassword = Objects.equals(clientGetted.get().getPassword(), clientToLogin.getPassword());

        if (hasSameEmail && hasSamePassword) {
            return clientGetted;
        } else {
            return Optional.of(new Client());
        }

    }

    public Boolean hasPermissions(Keyclient toEvaluate) {
        String key = toEvaluate.getKeyClient();
        Optional<Client> clientToEvaluate = repository.getClientByKeyClient(key);

        if (clientToEvaluate.isPresent()) {
            Client typeClient = clientToEvaluate.get();
            return (typeClient.getType() == ClientType.ADMIN);
        }
        return false;
    }

}
