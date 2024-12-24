package com.movie.reservation.service;

import com.movie.reservation.DTO.AvailabilityResponse;
import com.movie.reservation.DTO.BookSeatsDTO;
import com.movie.reservation.DTO.BookedSeatsResponse;
import com.movie.reservation.DTO.MoviesResponse;

public interface ReservationService {
    BookedSeatsResponse reserveSeats(BookSeatsDTO bookSeatsDTO);

    AvailabilityResponse getAvailability(String movieName);

    MoviesResponse getAllMovies();
}
