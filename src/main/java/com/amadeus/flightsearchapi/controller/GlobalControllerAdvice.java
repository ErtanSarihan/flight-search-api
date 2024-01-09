package com.amadeus.flightsearchapi.controller;

import com.amadeus.flightsearchapi.exception.AirportAlreadyExistsException;
import com.amadeus.flightsearchapi.exception.AirportDoesNotExistException;
import com.amadeus.flightsearchapi.exception.FlightDoesNotExistException;
import org.hibernate.TransientPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(TransientPropertyValueException.class)
    public ResponseEntity<ProblemDetail> handleTransientPropertyValueException(TransientPropertyValueException exception){
        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        detail.setType(URI.create("NOT_VALID"));
        detail.setDetail("Given airport id or ids are not valid!");
        detail.setTitle("Invalid Airport Value!");
        detail.setProperty("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(detail, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FlightDoesNotExistException.class)
    public ResponseEntity<ProblemDetail> handleFlightDoesNotExistException(FlightDoesNotExistException exception){
        ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,exception.getMessage());
        detail.setType(URI.create("NOT_FOUND"));
        detail.setTitle("Flight Not Found!");
        detail.setProperty("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(detail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AirportAlreadyExistsException.class)
    public ResponseEntity<ProblemDetail> handleAirportAlreadyExistsException(AirportAlreadyExistsException exception){
        ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,exception.getMessage());
        detail.setType(URI.create("RESOURCE_ALREADY_EXIST"));
        detail.setTitle("Airport Already Exists!");
        detail.setProperty("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(detail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AirportDoesNotExistException.class)
    public ResponseEntity<ProblemDetail> handleAirportDoesNotExistException(AirportDoesNotExistException exception){
        ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,exception.getMessage());
        detail.setType(URI.create("NOT_FOUND"));
        detail.setTitle("Airport Does Not Exist!");
        detail.setProperty("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(detail, HttpStatus.NOT_FOUND);
    }

}
