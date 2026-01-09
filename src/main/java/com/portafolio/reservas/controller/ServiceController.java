package com.portafolio.reservas.controller;

import com.portafolio.reservas.model.ServiceEntity;
import com.portafolio.reservas.service.ServiceEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceEntityService serviceEntityService;

    @GetMapping
    public Page<ServiceEntity> obtenerTodos(Pageable pageable) {
        return serviceEntityService.listarTodos(pageable);
    }

    @PostMapping
    // Aquí podrías agregar @PreAuthorize("hasRole('ADMIN')") más adelante
    public ServiceEntity crear(@RequestBody ServiceEntity servicio) {
        return serviceEntityService.guardar(servicio);
    }
}