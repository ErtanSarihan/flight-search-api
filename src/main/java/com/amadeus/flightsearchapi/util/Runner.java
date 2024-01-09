package com.amadeus.flightsearchapi.util;

import com.amadeus.flightsearchapi.dto.AirportDTO;
import com.amadeus.flightsearchapi.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {


    private final AirportService airportService;


    @Override
    public void run(String... args){


        AirportDTO cardakAirport = new AirportDTO("DNZ", "DENIZLI");
        AirportDTO sabihaAirport = new AirportDTO("SAW", "ISTANBUL");
        AirportDTO istanbulAirport = new AirportDTO("IST", "ISTANBUL");
        AirportDTO erzurumAirport = new AirportDTO("ERZ", "ERZURUM");
        AirportDTO batmanAirport = new AirportDTO("BAL", "BATMAN");
        airportService.createAirport(cardakAirport);
        airportService.createAirport(sabihaAirport);
        airportService.createAirport(istanbulAirport);
        airportService.createAirport(erzurumAirport);
        airportService.createAirport(batmanAirport);


    }
}
