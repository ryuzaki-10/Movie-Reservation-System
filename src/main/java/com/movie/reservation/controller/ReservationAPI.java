package com.movie.reservation.controller;

import com.movie.reservation.DTO.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ReservationAPI {
    @GetMapping("/getAllShows/{movieName}/{date}")
    List<GetAllShowsResponse> getAllMovies(@PathVariable String movieName, @PathVariable String date);

    @PostMapping("/bookMovieTickets")
    BookMovieTicketsResponse bookMovieTickets(@RequestBody BookMovieTicketsRequest bookMovieTicketsRequest);
}
