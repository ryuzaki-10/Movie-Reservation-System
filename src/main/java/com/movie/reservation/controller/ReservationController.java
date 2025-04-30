package com.movie.reservation.controller;

import com.movie.reservation.DTO.*;
import com.movie.reservation.model.Show;
import com.movie.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController implements ReservationAPI{
    @Autowired
    private ReservationService reservationService;

    @Override
    public GetAllShowsResponse getAllMovies(String movieName, String date) {
        return reservationService.getAllMovies(movieName,date);
    }

    @Override
    public BookMovieTicketsResponse bookMovieTickets(BookMovieTicketsRequest bookMovieTicketsRequest) {
        return reservationService.bookMovieTickets(bookMovieTicketsRequest);
    }
}
