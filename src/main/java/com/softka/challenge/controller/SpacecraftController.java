package com.softka.challenge.controller;


import com.softka.challenge.model.entity.spacecraft.Spacecraft;
import com.softka.challenge.services.SpacecraftServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ship")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET
//        , RequestMethod.POST, RequestMethod.PUT,
//        RequestMethod.DELETE
})
public class SpacecraftController {

    @Autowired
    private SpacecraftServices services;

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Spacecraft> getAllShips() {
        return services.allShips();
    }

    @PostMapping("/save")
    public @ResponseBody
    Spacecraft save(@RequestBody Spacecraft ship){
        return services.save(ship);
    }

}
