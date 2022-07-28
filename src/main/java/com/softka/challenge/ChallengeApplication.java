package com.softka.challenge;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeApplication implements CommandLineRunner {

    private final Log Logger = LogFactory.getLog(ChallengeApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        Logger.info("-----------------------------");
        Logger.info("INITIALIZED SUCCESSFULLY! :D ");
        Logger.info("-----------------------------");
    }
}
