package com.movie.reservation.service;

import com.movie.reservation.DTO.*;
import com.movie.reservation.model.Show;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ReservationService {
    SeatsOperationResponse reserveSeats(SeatsOperationDTO seatsOperationDTO);

    AvailabilityResponse getAvailability(GetAvailabilityRequest getAvailabilityRequest);

    MoviesResponse getAllMovies();

    SeatsOperationResponse cancelSeats(SeatsOperationDTO bookSeatsDTO);

    List<Show> getShowsByMovie(String movieName);
}
