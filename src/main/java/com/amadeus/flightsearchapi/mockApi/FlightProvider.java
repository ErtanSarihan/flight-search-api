package com.amadeus.flightsearchapi.mockApi;

import com.amadeus.flightsearchapi.dto.AirportDTO;
import com.amadeus.flightsearchapi.dto.FlightDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class FlightProvider {

    public List<FlightDTO> provideFlight(LocalDate date){
        List<FlightDTO> flights = new ArrayList<>();
        LocalDateTime dateTime = date.atStartOfDay();
        FlightDTO denizliIstanbul = FlightDTO.builder()
                .departuresAt(dateTime.plusHours(12))
                .landsAt(dateTime.plusHours(14))
                .departuresFrom(new AirportDTO("DNZ", "DENIZLI"))
                .landsTo(new AirportDTO("SAW", "ISTANBUL"))
                .price(200.0)
                .build();
        FlightDTO istanbulDenizli = FlightDTO.builder()
                .departuresAt(dateTime.plusHours(12))
                .landsAt(dateTime.plusHours(14))
                .departuresFrom(new AirportDTO("SAW", "ISTANBUL"))
                .landsTo(new AirportDTO("DNZ", "DENIZLI"))
                .price(150.0)
                .build();
        FlightDTO erzurumBatman = FlightDTO.builder()
                .departuresAt(dateTime.plusHours(12))
                .landsAt(dateTime.plusHours(14))
                .departuresFrom(new AirportDTO("ERZ", "ERZURUM"))
                .landsTo(new AirportDTO("BAL", "BATMAN"))
                .price(300.0)
                .build();
        FlightDTO batmanErzurum = FlightDTO.builder()
                .departuresAt(dateTime.plusHours(12))
                .landsAt(dateTime.plusHours(14))
                .departuresFrom(new AirportDTO("BAL", "BATMAN"))
                .landsTo(new AirportDTO("ERZ", "ERZURUM"))
                .price(200.0)
                .build();
        FlightDTO erzurumIstanbul = FlightDTO.builder()
                .departuresAt(dateTime.plusHours(12))
                .landsAt(dateTime.plusHours(14))
                .departuresFrom(new AirportDTO("ERZ", "ERZURUM"))
                .landsTo(new AirportDTO("IST", "ISTANBUL"))
                .price(300.0)
                .build();
        FlightDTO istanbulErzurum = FlightDTO.builder()
                .departuresAt(dateTime.plusHours(12))
                .landsAt(dateTime.plusHours(14))
                .departuresFrom(new AirportDTO("IST", "ISTANBUL"))
                .landsTo(new AirportDTO("ERZ", "ERZURUM"))
                .price(200.0)
                .build();


        flights.add(denizliIstanbul);
        flights.add(istanbulDenizli);
        flights.add(erzurumBatman);
        flights.add(batmanErzurum);
        flights.add(erzurumIstanbul);
        flights.add(istanbulErzurum);

        return flights;
    }

}
