package com.movie.reservation.model;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "movies")
public class Movie {
    @Id
    private int id;
    @TextIndexed
    private String name;
    private String duration;
    private List<String> cast;
}
