package com.amadeus.flightsearchapi.exception;

public class AirportDoesNotExistException extends RuntimeException{

    public AirportDoesNotExistException(String message) {
        super(message);
    }
}
