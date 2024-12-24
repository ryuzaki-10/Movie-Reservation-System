package com.movie.reservation.controller;

import com.movie.reservation.DTO.AvailabilityResponse;
import com.movie.reservation.DTO.BookSeatsDTO;
import com.movie.reservation.DTO.BookedSeatsResponse;
import com.movie.reservation.DTO.MoviesResponse;
import com.movie.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController implements ReservationAPI{
   @Autowired
    private ReservationService reservationService;

    public MoviesResponse getAllMovies() {
        return reservationService.getAllMovies();
    }


    public AvailabilityResponse getAvailability(String movieName) {
        return reservationService.getAvailability(movieName);
    }


    public BookedSeatsResponse reserveSeats(BookSeatsDTO bookSeatsDTO) {
        return reservationService.reserveSeats(bookSeatsDTO);
    }
}
