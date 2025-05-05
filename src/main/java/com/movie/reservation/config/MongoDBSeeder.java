package com.movie.reservation.config;

import com.movie.reservation.model.Movie;
import com.movie.reservation.model.Show;

import java.time.LocalDate;
import java.util.Date;

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
            mongoTemplate.dropCollection("shows");
            // Create sample movies
            Movie movie1 = new Movie();
            movie1.setId(1);
            movie1.setName("The Shawshank Redemption");
            movie1.setDuration("2:22");
            
            Movie movie2 = new Movie();
            movie2.setId(2);
            movie2.setName("The Godfather");
            movie2.setDuration("2:55");
            
            Movie movie3 = new Movie();
            movie3.setId(3);
            movie3.setName("Inception");
            movie3.setDuration("2:28");

            Show show1 = new Show();
            show1.setId("1");
            show1.setMovie(movie1);
            show1.setDate(new Date());
            show1.setTime("18:00");
           
            Show show2 = new Show();
            show2.setId("2");
            show2.setMovie(movie2);
            show2.setDate(new Date());
            show2.setTime("20:00");

            Show show3 = new Show();
            show3.setId("3");
            show3.setMovie(movie3);
            show3.setDate(new Date());
            show3.setTime("16:00");
            
            // Insert movies into MongoDB
            mongoTemplate.save(movie1);
            mongoTemplate.save(movie2);
            mongoTemplate.save(movie3);

            mongoTemplate.save(show1);
            mongoTemplate.save(show2);
            mongoTemplate.save(show3);
            System.out.println("Sample movies and shows have been added to the database.");
        };
    }
}