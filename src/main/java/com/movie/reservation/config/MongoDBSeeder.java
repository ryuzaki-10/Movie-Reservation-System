package com.movie.reservation.config;

import com.movie.reservation.model.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDBSeeder {

    @Bean
    CommandLineRunner runner(MongoTemplate mongoTemplate) {
        return args -> {
            // Clear existing data
            mongoTemplate.dropCollection("movies");
            
            // Create sample movies
            Movie movie1 = new Movie();
            movie1.setId(1);
            movie1.setName("The Shawshank Redemption");
            movie1.setDuration("2h 22min");
            
            Movie movie2 = new Movie();
            movie2.setId(2);
            movie2.setName("The Godfather");
            movie2.setDuration("2h 55min");
            
            Movie movie3 = new Movie();
            movie3.setId(3);
            movie3.setName("Inception");
            movie3.setDuration("2h 28min");
            
            // Insert movies into MongoDB
            mongoTemplate.save(movie1);
            mongoTemplate.save(movie2);
            mongoTemplate.save(movie3);
        };
    }
}