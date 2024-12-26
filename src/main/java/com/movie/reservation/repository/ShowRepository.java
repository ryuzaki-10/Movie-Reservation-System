package com.movie.reservation.repository;

import com.movie.reservation.model.Show;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends MongoRepository<Show,String> {
    public List<Show> findByMovieNameContains(String movieName);
}
