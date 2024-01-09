package com.amadeus.flightsearchapi.service;

import com.amadeus.flightsearchapi.dto.AirportDTO;
import com.amadeus.flightsearchapi.model.Airport;

import java.util.List;

public interface AirportService {

     List<AirportDTO> getAirports();

     AirportDTO getAirportById(String airportId);
     AirportDTO createAirport(AirportDTO airport);

     AirportDTO updateAirport(AirportDTO airport);

     Boolean deleteAirport(String airportId);
}
