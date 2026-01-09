package com.portafolio.reservas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La fecha y hora no pueden estar vacías")
    @Future(message = "La cita debe ser en una fecha futura")
    private LocalDateTime dateTime;

    @NotBlank(message = "El nombre del cliente es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String clientName;

    @Email(message = "El formato del correo electrónico no es válido")
    @NotBlank(message = "El correo electrónico es obligatorio")
    private String clientEmail;

    @NotNull(message = "Debes asignar un servicio a la cita")
    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceEntity service;
}