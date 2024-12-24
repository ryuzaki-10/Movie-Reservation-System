package com.movie.reservation.controller;

import com.movie.reservation.DTO.AvailabilityResponse;
import com.movie.reservation.DTO.BookSeatsDTO;
import com.movie.reservation.DTO.BookedSeatsResponse;
import com.movie.reservation.DTO.MoviesResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ReservationAPI {
    @GetMapping("/getAllMovies")
    public MoviesResponse getAllMovies();

    @GetMapping("/getAvailability/{movieName}")
    public AvailabilityResponse getAvailability(@PathVariable("movieName") String movieName);

    @PostMapping("/reserve")
    public BookedSeatsResponse reserveSeats(@RequestBody BookSeatsDTO bookSeatsDTO);
}
