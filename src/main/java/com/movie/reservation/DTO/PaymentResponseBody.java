package com.movie.reservation.DTO;

import lombok.Data;

@Data
public class PaymentResponseBody {
    private String id;
    private String requestId;
    private double amount;
    private Status status;
}
