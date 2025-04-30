package com.movie.reservation.DTO;

import lombok.Data;

@Data
public class BookMovieTicketsRequest {
    private String id;
    private String time;
    private String movieName;
    private String date;
}
