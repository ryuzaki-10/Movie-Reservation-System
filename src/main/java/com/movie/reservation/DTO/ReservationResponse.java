package com.movie.reservation.DTO;

import com.movie.reservation.model.Seat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {
    List<Seat> availableSeats;
}
