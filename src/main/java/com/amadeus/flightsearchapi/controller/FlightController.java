package com.amadeus.flightsearchapi.controller;

import com.amadeus.flightsearchapi.dto.FlightDTO;
import com.amadeus.flightsearchapi.dto.SearchRequestDTO;
import com.amadeus.flightsearchapi.dto.SearchResponseDTO;
import com.amadeus.flightsearchapi.service.FlightService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;


    @GetMapping
    public ResponseEntity<List<FlightDTO>> getFlights(){
        return ResponseEntity.ok(flightService.getFlights());
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<FlightDTO> getFlightById(@PathVariable Long flightId){
        return new ResponseEntity<>(flightService.getFlightById(flightId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FlightDTO> createFlight(@RequestBody @Valid FlightDTO flight){
        return new ResponseEntity<>(flightService.createFlight(flight), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<FlightDTO> updateFlight(@RequestBody @Valid FlightDTO flight){
        return new ResponseEntity<>(flightService.updateFlight(flight), HttpStatus.OK);
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<Boolean> deleteFlight(@PathVariable Long flightId){
        return new ResponseEntity<>(flightService.deleteFlight(flightId), HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<SearchResponseDTO> searchFlight(@RequestBody @Valid SearchRequestDTO searchRequestDTO){
        SearchResponseDTO response = flightService.getAvailableFlights(searchRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
