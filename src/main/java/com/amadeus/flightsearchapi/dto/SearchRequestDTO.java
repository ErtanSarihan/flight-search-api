package com.amadeus.flightsearchapi.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequestDTO {

    @NotBlank
    private String departureFrom;
    @NotBlank
    private String landTo;
    @NotNull
    private LocalDate departureDate;
    private LocalDate arrivalDate;

}
