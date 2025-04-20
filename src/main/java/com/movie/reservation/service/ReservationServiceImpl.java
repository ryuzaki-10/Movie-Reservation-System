package com.movie.reservation.service;

import com.movie.reservation.DTO.*;
import com.movie.reservation.model.Movie;
import com.movie.reservation.model.Show;
import com.movie.reservation.repository.MoviesRepository;
import com.movie.reservation.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MoviesRepository moviesRepository;

    @Override
    public SeatsOperationResponse reserveSeats(SeatsOperationDTO seatsOperationDTO) {
    return null;
    }

    @Override
    public AvailabilityResponse getAvailability(GetAvailabilityRequest getAvailabilityRequest) {
    return null;

    }

    @Override
    public MoviesResponse getAllMovies() {
      List<Movie> DBresponse =  moviesRepository.findAll();
      return MoviesResponse.builder().movieList(DBresponse).build();
    }

    @Override
    public SeatsOperationResponse cancelSeats(SeatsOperationDTO bookSeatsDTO) {
        return null;
    }

    @Override
    public List<Show> getShowsByMovie(String movieName) {
        List<Show> response = showRepository.findByMovieNameContains(movieName);
        return response;
    }
}
