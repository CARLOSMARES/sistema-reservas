package com.portafolio.reservas.controller;

import com.portafolio.reservas.model.Appointment;
import com.portafolio.reservas.service.AppointmentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> obtenerTodas() {
        return appointmentService.listarTodas();
    }

    @PostMapping
    public ResponseEntity<?> agendar(@Valid @RequestBody Appointment appointment) {
        try {
            Appointment nuevaCita = appointmentService.agendarCita(appointment);
            return ResponseEntity.ok(nuevaCita);
        } catch (RuntimeException e) {
            // Retorna un error 400 si hay conflicto de horario
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}