package com.movie.reservation.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Document
public class Seat {
    @Id
    private int seatNumber;
    private Boolean isBooked;
}
