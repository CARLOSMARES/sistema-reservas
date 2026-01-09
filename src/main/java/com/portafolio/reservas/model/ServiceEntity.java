package com.portafolio.reservas.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Entity
@Table(name = "services")
@Data
@EntityListeners(AuditingEntityListener.class) // Habilita auditoría
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Double price;

    private Integer durationMinutes;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
}