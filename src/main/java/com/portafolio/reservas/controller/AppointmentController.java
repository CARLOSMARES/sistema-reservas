package com.portafolio.reservas.controller;

import com.portafolio.reservas.model.Appointment;
import com.portafolio.reservas.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired private AppointmentService appointmentService;

    @GetMapping
    public Page<Appointment> obtenerTodas(Pageable pageable) {
        return appointmentService.listarTodas(pageable);
    }

    @PostMapping
    public ResponseEntity<Appointment> agendar(@Valid @RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.agendarCita(appointment));
    }
}