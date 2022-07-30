package com.softka.challenge.services;

import com.softka.challenge.Repository.spacecraftRepository;
import com.softka.challenge.model.entity.spacecraft.Spacecraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageTranscoder;
import java.util.List;

@Service
public class SpacecraftServices {

    @Autowired
    private spacecraftRepository repository;

    //GET


    public Iterable<Spacecraft> allShips() {
        return repository.findAll();
    }


    public Iterable<Spacecraft> searchBy(String parameter) {
        return repository.complexSearch(parameter);
    }


    //POST

    public Spacecraft save(Spacecraft ship) {
        return repository.save(ship);

    }


}
