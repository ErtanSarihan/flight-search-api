package com.amadeus.flightsearchapi.exception;

public class FlightDoesNotExistException extends RuntimeException{

    public FlightDoesNotExistException(String message) {
        super(message);
    }
}
