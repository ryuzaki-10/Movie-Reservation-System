package com.movie.reservation.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetAvailabilityRequest {
    private String movieName;
    private LocalDateTime showTime;
}
