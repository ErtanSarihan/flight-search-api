package com.amadeus.flightsearchapi.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AirportDTO {

    @NotBlank
    @Size(max = 4, min = 3)
    private String id;
    @NotBlank
    private String city;

}
