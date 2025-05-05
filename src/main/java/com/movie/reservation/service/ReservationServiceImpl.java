package com.movie.reservation.service;

import com.movie.reservation.DTO.*;
import com.movie.reservation.model.Movie;
import com.movie.reservation.model.Show;
import com.movie.reservation.model.Ticket;
import com.movie.reservation.repository.MoviesRepository;
import com.movie.reservation.repository.ShowRepository;
import com.movie.reservation.repository.TicketsRepository;
import com.movie.reservation.utils.DateConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    MoviesRepository moviesRepository;
    @Autowired
    TicketsRepository ticketsRepository;

    @Autowired
    DateConverterUtil dateConverterUtil;

    @Autowired
    ShowRepository showRepository;

    KafkaTemplate<String, BookMovieTicketsRequest> kafkaTemplate;


    @Override
    public List<GetAllShowsResponse> getAllShows(String movieName, String date) {
        Movie movie = moviesRepository.getMovieByName(movieName);
        System.out.println("Movie: " + movie);
        if(movie == null) {
            return null;
        }

        List<Show> shows = showRepository.findShowsByMovieName(movie.getName());
        System.out.println("Shows: " + shows);
        List<GetAllShowsResponse> getAllShowsResponses = new ArrayList<>();
        for(Show show : shows) {
            GetAllShowsResponse currGetAllShowsResponse = new GetAllShowsResponse();
            currGetAllShowsResponse.setMovieName(movie.getName());
            currGetAllShowsResponse.setDate(dateConverterUtil.dateToString(show.getDate()));
            currGetAllShowsResponse.setStartTime(show.getTime());
            currGetAllShowsResponse.setDate(dateConverterUtil.calculateTime(show.getTime(),movie.getDuration()));

            getAllShowsResponses.add(currGetAllShowsResponse);
        }

        return getAllShowsResponses;
    }

    @Override
    public BookMovieTicketsResponse bookMovieTickets(BookMovieTicketsRequest bookMovieTicketsRequest) {
        bookMovieTicketsRequest.setId(UUID.randomUUID().toString());
        Ticket ticket = new Ticket();
        ticket.setDate(bookMovieTicketsRequest.getDate());
        ticket.setTime(bookMovieTicketsRequest.getTime());
        ticket.setBooked(false);
        ticket.setMovieName(bookMovieTicketsRequest.getMovieName());
        ticket.setId(bookMovieTicketsRequest.getId());
        ticketsRepository.save(ticket);
        kafkaTemplate.send("book-tickets-request", bookMovieTicketsRequest);
        ticketsRepository.save(ticket);
        return isBooked(bookMovieTicketsRequest.getId());
    }

    private BookMovieTicketsResponse isBooked(String id) {
        Optional<Ticket> response = ticketsRepository.findById(id);
        BookMovieTicketsResponse bookMovieTicketsResponse = new BookMovieTicketsResponse();
        if(response.isPresent()) {
            Ticket ticket = response.get();
            bookMovieTicketsResponse.setId(ticket.getId());
            bookMovieTicketsResponse.setMovieName(ticket.getMovieName());
            bookMovieTicketsResponse.setTime(ticket.getTime());
            if(ticket.isBooked())
                bookMovieTicketsResponse.setStatus(Status.SUCCESS);
            else
                bookMovieTicketsResponse.setStatus(Status.FAILURE);
        }
        return bookMovieTicketsResponse;
    }

    @KafkaListener(topics = "successful-payments", groupId = "group_id")
    void ticketProcessor(PaymentResponseBody data) {
        if(data.getStatus() == Status.SUCCESS) {
            String requestId = data.getRequestId();
            ticketsRepository.updateTicketStatus(requestId, true);
        }
    }
}
