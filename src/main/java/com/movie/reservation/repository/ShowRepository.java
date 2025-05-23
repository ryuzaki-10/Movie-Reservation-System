package com.movie.reservation.repository;

import com.movie.reservation.model.Show;
import com.movie.reservation.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends MongoRepository<Show,String> {
    @Query("{'movie': ?0}")
    public List<Show> findShowsByMovie(Movie movie);
    
    @Aggregation(pipeline = {
        "{ $lookup: { from: 'movies', localField: 'movie.$id', foreignField: '_id', as: 'movieDetails' } }",
        "{ $match: { 'movieDetails.name': ?0 } }"
    })
    public List<Show> findShowsByMovieName(String movieName);
}
