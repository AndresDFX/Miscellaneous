package com.example.flightreservation.controller;

import com.example.flightreservation.FlightreservationApplication;
import com.example.flightreservation.config.DummyKafkaProducerConfig;
import com.example.flightreservation.dto.ReservationRequest;
import com.example.flightreservation.model.Flight;
import com.example.flightreservation.repository.FlightRepository;
import com.example.flightreservation.repository.ReservationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = FlightreservationApplication.class)
@AutoConfigureMockMvc(addFilters = false)  // Deshabilita la seguridad en tests de integración
@Import(DummyKafkaProducerConfig.class)  // Importa el bean dummy para Kafka
public class ReservationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        reservationRepository.deleteAll();
        flightRepository.deleteAll();
        // Crear un vuelo para las pruebas
        Flight flight = new Flight("AB123", 5);
        flightRepository.save(flight);
    }

    @Test
    public void testCreateReservationAndCancel() throws Exception {
        ReservationRequest request = new ReservationRequest();
        request.setFlightNumber("AB123");
        request.setSeatNumber("1A");

        // Crear reserva
        MvcResult result = mockMvc.perform(post("/api/reservations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.seatNumber").value("1A"))
            .andExpect(jsonPath("$.status").value("CONFIRMED"))
            .andReturn();

        // Extraer reservationId de la respuesta usando JsonPath
        String json = result.getResponse().getContentAsString();
        Long reservationId = com.jayway.jsonpath.JsonPath.parse(json).read("$.reservationId", Long.class);

        // Cancelar la reserva
        mockMvc.perform(delete("/api/reservations/" + reservationId))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value("CANCELED"));
    }
}
