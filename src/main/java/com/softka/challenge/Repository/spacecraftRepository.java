package com.softka.challenge.Repository;

import com.softka.challenge.model.entity.spacecraft.Spacecraft;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface spacecraftRepository extends PagingAndSortingRepository<Spacecraft, Integer> {

    @Query(value = "SELECT * FROM spacecraft", nativeQuery = true)
    List<Spacecraft> getAllShips();


    @Query(value = "SELECT * FROM spacecraft" +
            " WHERE description LIKE %?1% OR start_activity LIKE %?1%  OR end_activity LIKE %?1% OR country LIKE %?1% OR manufacturer LIKE %?1%", nativeQuery = true)
    Iterable<Spacecraft> complexSearch(String param);

}
