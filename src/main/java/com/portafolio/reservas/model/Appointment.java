package com.portafolio.reservas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private String clientName;

    private String clientEmail;

    // Relación Muchos a Uno: Muchas citas para un mismo servicio
    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceEntity service;
}