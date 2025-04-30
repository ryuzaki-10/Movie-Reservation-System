package com.movie.reservation.utils;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
@NoArgsConstructor
public class DateConverterUtil {

    public String dateToString(Date date) {
        // Convert Date -> Instant -> LocalDateTime
        LocalDateTime localDateTime = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        // Format as dd/MM/yyyy
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return localDateTime.format(formatter);
    }

    public String calculateTime(String time, String duration) {
        // Split the time string into hours and minutes
        String[] timeParts = time.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);

        // Split the duration string into hours and minutes
        String[] durationParts = duration.split(":");
        int durationHours = Integer.parseInt(durationParts[0]);
        int durationMinutes = Integer.parseInt(durationParts[1]);

        // Calculate the end time
        int endHours = hours + durationHours;
        int endMinutes = minutes + durationMinutes;

        // Adjust for overflow in minutes
        if (endMinutes >= 60) {
            endMinutes -= 60;
            endHours++;
        }

        // Adjust for overflow in hours
        if (endHours >= 24) {
            endHours -= 24;
        }

        // Format the end time as HH:mm
        return String.format("%02d:%02d", endHours, endMinutes);
    }
}
