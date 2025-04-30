package com.movie.reservation.service;


import com.movie.reservation.DTO.BookMovieTicketsRequest;
import com.movie.reservation.DTO.PaymentResponseBody;
import com.movie.reservation.DTO.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private KafkaTemplate<String, PaymentResponseBody> kafkaTemplate;

    @KafkaListener(topics = "book-tickets-request", groupId = "payment_group")
    public void processPayment(BookMovieTicketsRequest request) {

        PaymentResponseBody paymentResponseBody = new PaymentResponseBody();
        paymentResponseBody.setId(UUID.randomUUID().toString());
        paymentResponseBody.setRequestId(request.getId());
        paymentResponseBody.setAmount(100);
        try {
            // Process payment logic here
            boolean paymentSuccess = processPaymentTransaction(request);

            if (paymentSuccess) {

               paymentResponseBody.setStatus(Status.SUCCESS);
                kafkaTemplate.send("successful-payments", paymentResponseBody);
            }
        } catch (Exception e) {
            // Handle payment failure
            paymentResponseBody.setStatus(Status.FAILURE);
            System.out.println("Error processing payment: " + paymentResponseBody.toString());
        }
    }

    private boolean processPaymentTransaction(BookMovieTicketsRequest request) {
        // Simulate payment processing
        try {
            // Add your payment gateway integration here
            Thread.sleep(1000); // Simulating payment processing time
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }
}
