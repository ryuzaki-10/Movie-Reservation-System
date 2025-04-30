package com.movie.reservation.service;

import com.movie.reservation.DTO.*;
import com.movie.reservation.model.Show;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface ReservationService {
    List<GetAllShowsResponse> getAllShows(String movieName, String date);
    BookMovieTicketsResponse bookMovieTickets(BookMovieTicketsRequest bookMovieTicketsRequest);
}
