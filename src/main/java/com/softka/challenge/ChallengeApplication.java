package com.softka.challenge;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//@EntityScan("com.softka.challenge.model.entity")
//@ComponentScan({"com.softka.challenge.services","com.softka.challenge.controller"})
//@EnableJpaRepositories("com.softka.challenge")
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
