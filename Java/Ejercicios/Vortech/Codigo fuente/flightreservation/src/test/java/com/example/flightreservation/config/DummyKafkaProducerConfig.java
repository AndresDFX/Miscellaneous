package com.example.flightreservation.config;

import com.example.flightreservation.service.KafkaProducerService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class DummyKafkaProducerConfig {

    @Bean
    public KafkaProducerService kafkaProducerService() {
        // Devuelve una implementación dummy (no-op) para evitar la construcción de un KafkaProducer real
        return new KafkaProducerService(null) {
            @Override
            public void sendReservationEvent(String message) {
                // No se realiza ninguna acción (o se puede registrar en consola para debug)
                System.out.println("Dummy KafkaProducerService: Ignoring event: " + message);
            }
        };
    }
}
