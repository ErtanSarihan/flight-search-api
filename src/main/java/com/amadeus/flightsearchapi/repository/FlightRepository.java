package com.amadeus.flightsearchapi.repository;

import com.amadeus.flightsearchapi.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findAllByDeparturesFrom_CityAndLandsTo_CityAndDeparturesAtBetween(String departuresFrom, String landsTo, LocalDateTime departuresAtStart, LocalDateTime departuresAtEnd);

}
