package com.movie.reservation.service;

import com.movie.reservation.DTO.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ReservationService {
    List<GetAllShowsResponse> getAllShows(String movieName, String date);
    BookMovieTicketsResponse bookMovieTickets(BookMovieTicketsRequest bookMovieTicketsRequest);
}
