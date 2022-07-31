package com.softka.challenge.controller;


import com.softka.challenge.model.entity.client.Client;
import com.softka.challenge.services.ClientServices;
import com.softka.challenge.services.SpacecraftServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientController {

    @Autowired
    private ClientServices services;

    @GetMapping("/all")
    public List<Client> allClients(){
        return services.getAllClients();
    }


    // - POST

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client registerClient(@RequestBody Client client) {
        return services.register(client);
    }


    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Optional<Client> login(@RequestBody Client clientReceive) {
        return services.login(clientReceive);
    }


}
