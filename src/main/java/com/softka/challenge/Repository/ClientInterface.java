package com.softka.challenge.Repository;

import com.softka.challenge.model.entity.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Repository
public interface ClientInterface extends JpaRepository<Client, Integer> {

    Optional<Client> findClientByEmail(String email);

    Optional<Client> findClientByKeyClient(String keyClient);

    @Query(value = "SELECT * FROM client WHERE '?1' ", nativeQuery = true)
    Optional<Client> getClientByEmail(String email);


}
