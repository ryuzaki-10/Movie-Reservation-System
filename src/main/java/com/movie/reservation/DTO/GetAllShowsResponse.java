package com.movie.reservation.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllShowsResponse {
    private String movieName;
    private String date;
    private String startTime;
    private String endTime;
    private List<Error> errorList;

}
