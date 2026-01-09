package com.portafolio.reservas.controller;

import com.portafolio.reservas.config.JwtUtils;
import com.portafolio.reservas.model.User;
import com.portafolio.reservas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        // En un caso real, aquí encriptarías la clave con BCrypt
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return ResponseEntity.ok("Usuario registrado con éxito");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        // Validación simple para el portafolio
        return userRepository.findByUsername(username)
            .filter(user -> user.getPassword().equals(password))
            .map(user -> {
                String token = jwtUtils.generateJwtToken(username);
                return ResponseEntity.ok(Map.of("token", token));
            })
            .orElse(ResponseEntity.status(401).body(Map.of("error", "Credenciales inválidas")));
    }
}