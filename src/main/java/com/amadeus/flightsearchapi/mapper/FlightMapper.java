package com.amadeus.flightsearchapi.mapper;

import com.amadeus.flightsearchapi.dto.FlightDTO;
import com.amadeus.flightsearchapi.model.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface FlightMapper {

    FlightDTO toDto(Flight flight);

    Flight toEntity(FlightDTO flightDTO);

}
