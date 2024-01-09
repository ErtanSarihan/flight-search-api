package com.amadeus.flightsearchapi.repository;

import com.amadeus.flightsearchapi.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AirportRepository extends JpaRepository<Airport, String> {

}
