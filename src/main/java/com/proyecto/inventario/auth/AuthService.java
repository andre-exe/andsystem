package com.proyecto.inventario.auth;

import com.proyecto.inventario.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public LoginResponse login(LoginRequest request) {
    try {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
    } catch (Exception e) {
        // Agrega esto temporalmente
        System.out.println("ERROR DE AUTH: " + e.getClass().getName() + " - " + e.getMessage());
        throw e;
    }

    String token = jwtService.generateToken(request.getUsername());
    return new LoginResponse(token);
}
}