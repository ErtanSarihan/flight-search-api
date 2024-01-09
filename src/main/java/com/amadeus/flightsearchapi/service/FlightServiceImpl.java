package com.amadeus.flightsearchapi.service;

import com.amadeus.flightsearchapi.dto.FlightDTO;
import com.amadeus.flightsearchapi.dto.SearchRequestDTO;
import com.amadeus.flightsearchapi.dto.SearchResponseDTO;
import com.amadeus.flightsearchapi.exception.FlightDoesNotExistException;
import com.amadeus.flightsearchapi.mapper.FlightMapper;
import com.amadeus.flightsearchapi.model.Flight;
import com.amadeus.flightsearchapi.repository.FlightRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    private final RestTemplate restTemplate = new RestTemplate();
    private LocalDate date = LocalDate.of(2023, 05,07);
    private final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    @Scheduled(fixedRate = 15000)
    public void getDailyFlights(){
        String url = "http://localhost:8080/api/mock/flights?date=" + date.toString();
        date = date.plusDays(1);
        List<Object> response = restTemplate.getForObject(url, List.class);
        List<FlightDTO> flights = objectMapper.convertValue(response, new TypeReference<List<FlightDTO>>() {});
        flightRepository.saveAll(flights.stream().map(flightMapper::toEntity).toList());
    }
    @Override
    public List<FlightDTO> getFlights() {
        return flightRepository.findAll().stream().map(flightMapper::toDto).toList();
    }

    @Override
    public FlightDTO getFlightById(Long flightId) {
        if (flightRepository.findById(flightId).isEmpty()) {
            throw new FlightDoesNotExistException("Flight with id:"+ flightId +  " does not exist!");
        }
        return flightMapper.toDto(flightRepository.getReferenceById(flightId));
    }

    @Override
    public FlightDTO createFlight(FlightDTO flight) {
        Flight saved = flightRepository.save(flightMapper.toEntity(flight));
        return flightMapper.toDto(saved);
    }

    @Override
    public FlightDTO updateFlight(FlightDTO flight) {
        if (flightRepository.findById(flight.getId()).isEmpty()) {
            throw new FlightDoesNotExistException("Flight with id:"+ flight.getId() +  " does not exist!");
        }
        Flight saved = flightRepository.save(flightMapper.toEntity(flight));
        return flightMapper.toDto(saved);
    }

    @Override
    public Boolean deleteFlight(Long flightId) {
        if (flightRepository.findById(flightId).isEmpty()) {
            throw new FlightDoesNotExistException("Flight with id:"+ flightId +  " does not exist!");
        }
        flightRepository.deleteById(flightId);
        return true;
    }

    @Override
    public SearchResponseDTO getAvailableFlights(SearchRequestDTO searchRequestDTO) {
        SearchResponseDTO response = new SearchResponseDTO();
        List<Flight> availableDepartureFlights = flightRepository.findAllByDeparturesFrom_CityAndLandsTo_CityAndDeparturesAtBetween(searchRequestDTO
                .getDepartureFrom(), searchRequestDTO.getLandTo(), searchRequestDTO.getDepartureDate().atStartOfDay(), searchRequestDTO.getDepartureDate()
                .atTime(23, 59, 59));
        response.setAvailableDepartureFlights(availableDepartureFlights.stream().map(flightMapper::toDto).toList());
        if (searchRequestDTO.getArrivalDate() != null) {
            List<Flight> availableArrivalFlights = flightRepository.findAllByDeparturesFrom_CityAndLandsTo_CityAndDeparturesAtBetween(searchRequestDTO
                    .getLandTo(), searchRequestDTO.getDepartureFrom(), searchRequestDTO.getArrivalDate().atStartOfDay(), searchRequestDTO.getArrivalDate()
                    .atTime(23, 59, 59));
            response.setAvailableArrivalFlights(availableArrivalFlights.stream().map(flightMapper::toDto).toList());
        }
        return response;
    }
}
