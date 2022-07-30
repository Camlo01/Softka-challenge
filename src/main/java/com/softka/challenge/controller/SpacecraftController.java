package com.softka.challenge.controller;


import com.softka.challenge.model.entity.spacecraft.Spacecraft;
import com.softka.challenge.services.SpacecraftServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ship")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SpacecraftController {

    @Autowired
    private SpacecraftServices services;

    //--GET

    @GetMapping("/all")
    public Iterable<Spacecraft> getAllShips() {
        return services.allShips();
    }

    @GetMapping("/search={parameter}")
    public Iterable<Spacecraft> searchShip(@PathVariable("parameter") String parameter) {
        return services.searchBy(parameter);
    }

    //--POST

    @PostMapping("/save")
    public @ResponseBody
    Spacecraft save(@RequestBody Spacecraft ship) {
        System.out.println(ship.getName());
        return services.save(ship);
    }



}
