package com.softka.challenge.model.DTO.Wrapper;

import com.softka.challenge.model.entity.client.Keyclient;
import com.softka.challenge.model.entity.spacecraft.Spacecraft;

public class SpacecraftKeyclient {
    private Spacecraft spacecraft;

    private Keyclient keyclient;

    public SpacecraftKeyclient(Spacecraft spacecraft, Keyclient keyclient) {
        this.spacecraft = spacecraft;
        this.keyclient = keyclient;
    }

    public Spacecraft getSpacecraft() {
        return spacecraft;
    }

    public void setSpacecraft(Spacecraft spacecraft) {
        this.spacecraft = spacecraft;
    }

    public Keyclient getKeyclient() {
        return keyclient;
    }

    public void setKeyclient(Keyclient keyclient) {
        this.keyclient = keyclient;
    }
}
