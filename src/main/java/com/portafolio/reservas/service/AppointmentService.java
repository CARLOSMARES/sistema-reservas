package com.portafolio.reservas.service;

import com.portafolio.reservas.model.Appointment;
import com.portafolio.reservas.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired private AppointmentRepository appointmentRepository;
    @Autowired private EmailService emailService;

    public Page<Appointment> listarTodas(Pageable pageable) {
        return appointmentRepository.findAll(pageable);
    }

    public Appointment agendarCita(Appointment appointment) {
        if (!appointmentRepository.findByDateTimeAndServiceId(appointment.getDateTime(), appointment.getService().getId()).isEmpty()) {
            throw new RuntimeException("Horario ocupado");
        }
        Appointment guardado = appointmentRepository.save(appointment);
        emailService.enviarConfirmacion(guardado.getClientEmail(), guardado.getClientName());
        return guardado;
    }
}