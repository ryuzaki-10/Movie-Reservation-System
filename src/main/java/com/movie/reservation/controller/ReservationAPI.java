package com.movie.reservation.controller;

import com.movie.reservation.DTO.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ReservationAPI {
    @GetMapping("/getAllShows")
    List<GetAllShowsResponse> getAllMovies(@RequestParam(required = false) String movieName, @RequestParam(required = false) String date);

    @PostMapping("/bookMovieTickets")
    BookMovieTicketsResponse bookMovieTickets(@RequestBody BookMovieTicketsRequest bookMovieTicketsRequest);
}
