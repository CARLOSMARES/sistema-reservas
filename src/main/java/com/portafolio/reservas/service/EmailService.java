package com.portafolio.reservas.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void enviarConfirmacion(String to, String cliente) {
        System.out.println("SIMULACIÓN EMAIL: Enviando confirmación a " + to);
    }
}