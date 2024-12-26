package com.movie.reservation.controller;

import com.movie.reservation.DTO.*;
import com.movie.reservation.model.Show;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ReservationAPI {
    @GetMapping("/getAllMovies")
    MoviesResponse getAllMovies();

    @GetMapping("/getShowsByMovie/{movieName}")
    List<Show> getShowsByMovie(@PathVariable("movieName") String movieName);

    @PostMapping("/getAvailability")
    AvailabilityResponse getAvailability(@RequestBody GetAvailabilityRequest getAvailabilityRequest);

    @PostMapping("/reserve")
    SeatsOperationResponse reserveSeats(@RequestBody SeatsOperationDTO bookSeatsDTO);

    @PostMapping("/cancel")
    SeatsOperationResponse cancelSeats(@RequestBody SeatsOperationDTO cancelSeatsDTO);
}
