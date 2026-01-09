package com.portafolio.reservas.controller;

import com.portafolio.reservas.model.ServiceEntity;
import com.portafolio.reservas.service.ServiceEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "*") // Permite peticiones desde cualquier origen (útil para el frontend)
public class ServiceController {

    @Autowired
    private ServiceEntityService serviceEntityService;

    @GetMapping
    public List<ServiceEntity> obtenerTodos() {
        return serviceEntityService.listarTodos();
    }

    @PostMapping
    public ServiceEntity crear(@RequestBody ServiceEntity servicio) {
        return serviceEntityService.guardar(servicio);
    }
}