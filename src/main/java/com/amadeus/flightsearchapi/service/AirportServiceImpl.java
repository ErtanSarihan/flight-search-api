package com.amadeus.flightsearchapi.service;


import com.amadeus.flightsearchapi.dto.AirportDTO;
import com.amadeus.flightsearchapi.exception.AirportAlreadyExistsException;
import com.amadeus.flightsearchapi.exception.AirportDoesNotExistException;
import com.amadeus.flightsearchapi.mapper.AirportMapper;
import com.amadeus.flightsearchapi.model.Airport;
import com.amadeus.flightsearchapi.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService{

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    public List<AirportDTO> getAirports(){
        return airportRepository.findAll().stream().map(airportMapper::toDto).toList();
    }

    @Override
    public AirportDTO getAirportById(String airportId) {
        return airportRepository.findById(airportId).map(airportMapper::toDto).orElseThrow(() -> new AirportDoesNotExistException("Airport with given id:" + airportId + " does not exist!"));

    }

    @Override
    public AirportDTO createAirport(AirportDTO airport) {
        if(airportRepository.findById(airport.getId()).isPresent()){
            throw new AirportAlreadyExistsException("An airport with given id:" + airport.getId() + " already exists!");
        }
        Airport saved = airportRepository.save(airportMapper.toEntity(airport));
        return airportMapper.toDto(saved);
    }

    @Override
    public AirportDTO updateAirport(AirportDTO airport) {
        if(airportRepository.findById(airport.getId()).isEmpty()){
            throw new AirportDoesNotExistException("Airport with given id:" + airport.getId() + " does not exist!");
        }
        Airport saved = airportRepository.save(airportMapper.toEntity(airport));
        return airportMapper.toDto(saved);
    }

    @Override
    public Boolean deleteAirport(String airportId){
        if(airportRepository.findById(airportId).isEmpty()){
            throw new AirportDoesNotExistException("Airport with given id:" + airportId + " does not exist!");
        }
        airportRepository.deleteById(airportId);
        return true;
    }
}
