package com.movie.reservation.DTO;

import com.movie.reservation.model.Movie;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MoviesResponse {
    private List<Movie> movieList;
}
