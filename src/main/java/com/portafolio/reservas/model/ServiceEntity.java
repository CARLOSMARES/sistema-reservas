package com.portafolio.reservas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@SuppressWarnings("unused")
@Entity
@Table(name = "services")
@Data
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Double price;

    private Integer durationMinutes;
}