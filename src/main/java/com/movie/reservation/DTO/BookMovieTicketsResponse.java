package com.movie.reservation.DTO;

import lombok.Data;

@Data
public class BookMovieTicketsResponse {
    private String id;
    private String movieName;
    private String time;
    private Status status;
}
