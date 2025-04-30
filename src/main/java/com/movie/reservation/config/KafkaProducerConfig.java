package com.movie.reservation.config;

import com.movie.reservation.DTO.BookMovieTicketsRequest;

import com.movie.reservation.DTO.PaymentResponseBody;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    public Map<String,Object> producerConfig() {
        Map<String,Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, String.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, BookMovieTicketsRequest.class);
        return props;
    }

    @Bean
    public ProducerFactory<String,BookMovieTicketsRequest> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String, BookMovieTicketsRequest> kafkaTemplate(ProducerFactory<String,BookMovieTicketsRequest> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }


    public Map<String,Object> stringProducerConfig() {
        Map<String,Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, PaymentResponseBody.class);
        return props;
    }

    @Bean
    public ProducerFactory<String,PaymentResponseBody> stringProducerFactory() {
        return new DefaultKafkaProducerFactory<>(stringProducerConfig());
    }

    @Bean
    public KafkaTemplate<String, PaymentResponseBody> stringKafkaTemplate(ProducerFactory<String,PaymentResponseBody> stringProducerFactory) {
        return new KafkaTemplate<>(stringProducerFactory);
    }
 }
