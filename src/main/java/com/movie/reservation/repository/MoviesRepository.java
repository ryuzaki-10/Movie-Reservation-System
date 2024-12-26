package com.movie.reservation.repository;

import com.movie.reservation.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends MongoRepository<Movie,Integer> {

}
