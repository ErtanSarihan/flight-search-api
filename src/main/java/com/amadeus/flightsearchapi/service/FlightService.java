package com.amadeus.flightsearchapi.service;


import com.amadeus.flightsearchapi.dto.FlightDTO;
import com.amadeus.flightsearchapi.dto.SearchRequestDTO;
import com.amadeus.flightsearchapi.dto.SearchResponseDTO;

import java.util.List;

public interface FlightService {

    List<FlightDTO> getFlights();

    FlightDTO getFlightById(Long flightId);

    FlightDTO createFlight(FlightDTO flight);

    FlightDTO updateFlight(FlightDTO flight);

    Boolean deleteFlight(Long flightId);

    SearchResponseDTO getAvailableFlights(SearchRequestDTO searchRequestDTO);
}
