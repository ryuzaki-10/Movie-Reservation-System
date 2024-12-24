package com.movie.reservation.DTO;

import com.movie.reservation.model.Seat;
import lombok.Data;

import java.util.List;

@Data
public class AvailabilityResponse {
    private String movieName;
    private int totalSeatsAvailable;
    private List<Seat> availableSeats;
}
