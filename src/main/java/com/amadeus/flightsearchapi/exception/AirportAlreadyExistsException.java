package com.amadeus.flightsearchapi.exception;

public class AirportAlreadyExistsException extends RuntimeException{

    public AirportAlreadyExistsException(String message) {
        super(message);
    }
}
