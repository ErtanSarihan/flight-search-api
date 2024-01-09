package com.amadeus.flightsearchapi.mapper;

import com.amadeus.flightsearchapi.dto.AirportDTO;
import com.amadeus.flightsearchapi.model.Airport;
import org.mapstruct.Mapper;

@Mapper
public interface AirportMapper {

    AirportDTO toDto(Airport airport);

    Airport toEntity(AirportDTO airportDTO);

}
