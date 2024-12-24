package com.movie.reservation.DTO;

import com.movie.reservation.model.Seat;
import lombok.Data;

import java.util.List;

@Data
public class BookSeatsDTO {
    List<Seat> seats;
}
