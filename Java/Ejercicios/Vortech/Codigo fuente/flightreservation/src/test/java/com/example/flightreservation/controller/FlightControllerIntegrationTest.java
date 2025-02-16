package com.example.flightreservation.controller;

import com.example.flightreservation.FlightreservationApplication;
import com.example.flightreservation.dto.FlightCreationRequest;
import com.example.flightreservation.repository.FlightRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = FlightreservationApplication.class)
@AutoConfigureMockMvc(addFilters = false)  // Deshabilita los filtros de seguridad
public class FlightControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        flightRepository.deleteAll();
    }

    @Test
    public void testCreateAndGetFlightAvailability() throws Exception {
        FlightCreationRequest request = new FlightCreationRequest();
        request.setFlightNumber("AB123");
        request.setTotalSeats(5);

        // Crear vuelo
        mockMvc.perform(post("/api/flights")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.flightNumber").value("AB123"))
            .andExpect(jsonPath("$.totalSeats").value(5))
            .andExpect(jsonPath("$.availableSeats").value(5));

        // Consultar disponibilidad
        mockMvc.perform(get("/api/flights/AB123/availability"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.flightNumber").value("AB123"))
            .andExpect(jsonPath("$.totalSeats").value(5))
            .andExpect(jsonPath("$.availableSeats").value(5));
    }
}
