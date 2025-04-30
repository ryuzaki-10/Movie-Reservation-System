package com.movie.reservation.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Document(collection="shows")
public class Show {
    @Id
    private String id;
    private Date date;
    private String time;
    @DocumentReference(lazy = true)
    private Movie movie;
    private List<Seat> seats;
}
