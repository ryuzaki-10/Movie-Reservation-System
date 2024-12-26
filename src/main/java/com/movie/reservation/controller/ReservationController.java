package com.movie.reservation.controller;

import com.movie.reservation.DTO.*;
import com.movie.reservation.model.Show;
import com.movie.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController implements ReservationAPI{
   @Autowired
    private ReservationService reservationService;

    public MoviesResponse getAllMovies() {
        return reservationService.getAllMovies();
    }

    @Override
    public List<Show> getShowsByMovie(String movieName) {
        return List.of();
    }


    public AvailabilityResponse getAvailability(GetAvailabilityRequest getAvailabilityRequest) {
        return reservationService.getAvailability(getAvailabilityRequest);
    }


    public SeatsOperationResponse reserveSeats(SeatsOperationDTO seatsOperationDTO) {
        return reservationService.reserveSeats(seatsOperationDTO);
    }

    @Override
    public SeatsOperationResponse cancelSeats(SeatsOperationDTO cancelSeatsDTO) {
        return null;
    }
}
