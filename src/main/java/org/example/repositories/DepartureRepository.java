package org.example.repositories;

import org.example.entities.Departure;
import org.example.entities.PostOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DepartureRepository extends JpaRepository<Departure,Long> {
    List<Departure> findDeparturesByDepartureDate(String date);
    List<Departure> findDeparturesByType(String type);

    List<Departure> findDeparturesByOffice(PostOffice office);
}
