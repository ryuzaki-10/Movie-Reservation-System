package com.movie.reservation.DTO;

import com.movie.reservation.model.Movie;
import lombok.Data;

import java.util.List;

@Data
public class MoviesResponse {
    private List<Movie> movieList;
}
