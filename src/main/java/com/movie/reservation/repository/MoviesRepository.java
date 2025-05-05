package com.movie.reservation.repository;

import com.movie.reservation.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends MongoRepository<Movie,Integer> {

    @Query("{'name': ?0}")
   Movie getMovieByName(String name);
}
