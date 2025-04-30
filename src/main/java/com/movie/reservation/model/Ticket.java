package com.movie.reservation.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "tickets")
public class Ticket {
    @Id
    private String id;
    private String movieName;
    private String date;
    private String time;
    private boolean isBooked;
}
