package com.softka.challenge.model.entity.client;

import java.util.Random;

public class Keyclient {

    private String keyClient;

    public Keyclient(String keyClient) {
        this.keyClient = keyClient;
    }

    public Keyclient() {
        this.keyClient = generateKeyClient();
    }

    public String getKeyClient() {
        return keyClient;
    }

    public void setKeyClient(String keyClient) {
        this.keyClient = keyClient;
    }

    public String generateKeyClient() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
