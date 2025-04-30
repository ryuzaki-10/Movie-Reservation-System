package com.movie.reservation.DTO;

import lombok.Data;

/**
 * This enum represents the status of a reservation operation.
 * It can be used to indicate whether the operation was successful, failed, or is pending.
 */
public enum Status {
    SUCCESS("Success"),
    FAILURE("Failure"),
    PENDING("Pending");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
