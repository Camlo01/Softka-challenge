package com.softka.challenge.services;

import com.softka.challenge.Repository.spacecraftRepository;
import com.softka.challenge.model.entity.client.Keyclient;
import com.softka.challenge.model.entity.spacecraft.Spacecraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageTranscoder;
import java.util.List;

@Service
public class SpacecraftServices {

    @Autowired
    private spacecraftRepository repository;
    @Autowired
    private ClientServices clientServices;

    //GET


    public Iterable<Spacecraft> allShips() {
        return repository.findAll();
    }


    public Iterable<Spacecraft> searchBy(String parameter) {
        return repository.complexSearch(parameter);
    }


    //POST

    public Spacecraft saveShip(Spacecraft ship, Keyclient key){
        if(clientServices.hasPermissions(key)){
            return repository.save(ship);
        }
        return null;
    }

    private Spacecraft save(Spacecraft ship) {
        return repository.save(ship);

    }
    //PUT

    public Spacecraft update(Spacecraft ship, Keyclient key) {
        if(clientServices.hasPermissions(key)) {
            return repository.save(ship);
        }
        return  new Spacecraft();
    }
    //DELETE
    public boolean deleteShip(int id, Keyclient key){

        if(clientServices.hasPermissions(key)) {
            return repository.findById(id).map(clientGetted -> {
                repository.delete(clientGetted);
                return true;
            }).orElse(false);
        }
        return false;
    }


}
