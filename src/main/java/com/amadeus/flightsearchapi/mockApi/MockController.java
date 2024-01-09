package com.amadeus.flightsearchapi.mockApi;

import com.amadeus.flightsearchapi.dto.FlightDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/mock/flights")
@RequiredArgsConstructor
public class MockController {

    private final FlightProvider flightProvider;

    @GetMapping
    public ResponseEntity<List<FlightDTO>> getFlights(@RequestParam ("date")
                                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return new ResponseEntity<>(flightProvider.provideFlight(date), HttpStatus.OK);
    }

}
