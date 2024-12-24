package com.movie.reservation.repository;

import com.movie.reservation.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MoviesRepository extends MongoRepository<Movie,Integer> {
}
