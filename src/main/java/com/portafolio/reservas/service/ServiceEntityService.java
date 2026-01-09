package com.portafolio.reservas.service;

import com.portafolio.reservas.model.ServiceEntity;
import com.portafolio.reservas.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceEntityService {

    @Autowired
    private ServiceRepository serviceRepository;

    public Page<ServiceEntity> listarTodos(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    public ServiceEntity guardar(ServiceEntity servicio) {
        return serviceRepository.save(servicio);
    }
}