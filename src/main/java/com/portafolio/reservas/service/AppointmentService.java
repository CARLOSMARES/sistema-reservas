package com.portafolio.reservas.service;

import com.portafolio.reservas.model.Appointment;
import com.portafolio.reservas.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> listarTodas() {
        return appointmentRepository.findAll();
    }

    public Appointment agendarCita(Appointment appointment) {
        // VALIDACIÓN: No permitir dos citas al mismo tiempo para el mismo servicio
        List<Appointment> conflictos = appointmentRepository
            .findByDateTimeAndServiceId(appointment.getDateTime(), appointment.getService().getId());

        if (!conflictos.isEmpty()) {
            throw new RuntimeException("Error: El horario seleccionado ya está ocupado.");
        }

        return appointmentRepository.save(appointment);
    }
}