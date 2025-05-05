package com.movie.reservation.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection="shows")
public class Show {
    @Id
    private String id;
    private Date date;
    private String time;
    @DBRef(lazy = true)
    private Movie movie;
}
