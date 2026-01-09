package com.portafolio.reservas.service;

import com.portafolio.reservas.model.ServiceEntity;
import com.portafolio.reservas.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceEntityService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<ServiceEntity> listarTodos() {
        return serviceRepository.findAll();
    }

    public ServiceEntity guardar(ServiceEntity servicio) {
        return serviceRepository.save(servicio);
    }

    public void eliminar(Long id) {
        serviceRepository.deleteById(id);
    }
}