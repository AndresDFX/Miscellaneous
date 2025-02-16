package com.example.flightreservation.controller;

import com.example.flightreservation.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private JwtTokenProvider tokenProvider;
    
    // Endpoint para autenticarse y obtener un token JWT
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthRequest authRequest) {
        if ("admin".equals(authRequest.getUsername()) && "admin".equals(authRequest.getPassword())) {
            String token = tokenProvider.generateToken(authRequest.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
}
