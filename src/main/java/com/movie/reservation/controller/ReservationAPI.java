package com.movie.reservation.controller;

import com.movie.reservation.DTO.*;
import com.movie.reservation.model.Show;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ReservationAPI {
    @GetMapping("/getAllShows/{movieName}/{date}")
    List<GetAllShowsResponse> getAllMovies(@RequestParam String movieName, @RequestParam String date);

    @PostMapping("/bookMovieTickets")
    BookMovieTicketsResponse bookMovieTickets(@RequestBody BookMovieTicketsRequest bookMovieTicketsRequest);
}
