package com.linkedin.learning.rest;

import com.linkedin.learning.model.request.ReservationRequest;
import com.linkedin.learning.model.response.ReservationResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * Created by ncont on 8/8/2017.
 */

/**
 * Annotation combines @Controller with @RequestBody
 * It is a specialization of the component annotation
 * that  marks a candidate for auto-detection through
 * classpath scanning.
 *
 * HTTP requests are intercepted by the DispatcherServlet
 * which looks for handler mappings and its type, then
 * routes that request to the correct RestController method.
 *
 * A response body annotation indicates a method return value
 * should be bound to the web response body.
 */
@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
public class ReservationResource {

    // RequestMapping annotation maps web requests onto specific handler classes/methods.
    @RequestMapping(path="", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservationResponse> getAvailableRooms(
            // RequestParam basically maps input values to variables in the function.
            @RequestParam(value = "checkin")
            // DateTimeFormat declares that a field or method should be formatted as date or time
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate checkIn,
            @RequestParam(value = "checkout")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate checkOut) {

        return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
    }

    @RequestMapping(path="", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservationResponse> createReservation(
            @RequestBody
            ReservationRequest reservationRequest) {

        return new ResponseEntity<>(new ReservationResponse(), HttpStatus.CREATED);
    }

    @RequestMapping(path="", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservationResponse> updateReservation(
            // RequestBody indicates that a method param should be bound to the body of the web request
            @RequestBody
            ReservationRequest reservationRequest) {

        return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{reservationId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteReservation(
            // The variable with the PathVariable annotation is used in the RequestMapping path above
            @PathVariable
            long reservationId) {

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
