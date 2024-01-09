package com.amadeus.flightsearchapi.controller;

import com.amadeus.flightsearchapi.dto.AirportDTO;
import com.amadeus.flightsearchapi.service.AirportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/airports")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @GetMapping
    public ResponseEntity<List<AirportDTO>> getAirports(){
        return ResponseEntity.ok(airportService.getAirports());
    }

    @GetMapping("/{airportId}")
    public ResponseEntity<AirportDTO> getAirportById(@PathVariable String airportId){
        return new ResponseEntity<>(airportService.getAirportById(airportId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AirportDTO> createAirport(@RequestBody @Valid AirportDTO airport){
        return new ResponseEntity<>(airportService.createAirport(airport), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AirportDTO> updateAirport(@RequestBody @Valid AirportDTO airport){
        return new ResponseEntity<>(airportService.updateAirport(airport), HttpStatus.OK);
    }

    @DeleteMapping("/{airportId}")
    public ResponseEntity<Boolean> deleteAirport(@PathVariable String airportId){
        return new ResponseEntity<>(airportService.deleteAirport(airportId), HttpStatus.OK);
    }

}
