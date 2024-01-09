package com.amadeus.flightsearchapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightDTO {

    private Long id;

    @NotNull
    private @Valid AirportDTO departuresFrom;

    @NotNull
    private @Valid AirportDTO landsTo;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    @NotNull
    private LocalDateTime departuresAt;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    @NotNull
    private LocalDateTime landsAt;

    @Min(0L)
    private double price;

}
