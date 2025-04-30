package com.movie.reservation.repository;

import com.movie.reservation.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsRepository extends MongoRepository<Ticket,String> {

    @Query("{'id' : ?0}")
    @Update("{$set : {'isBooked' : ?1}}")
    void updateTicketStatus(String id, boolean status);
}
