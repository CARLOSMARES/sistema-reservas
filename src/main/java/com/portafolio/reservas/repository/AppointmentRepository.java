package com.portafolio.reservas.repository;

import com.portafolio.reservas.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // Buscar todas las citas de un servicio en una fecha y hora específica
    List<Appointment> findByDateTimeAndServiceId(LocalDateTime dateTime, Long serviceId);
}