package com.portafolio.reservas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.context.request.WebRequest;

import com.portafolio.reservas.model.ErrorMessage;

import java.time.LocalDateTime;

@SuppressWarnings("unused")
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Maneja la excepción específica que creamos para conflictos de citas
    @ExceptionHandler(RuntimeException.class)
    public ErrorMessage handleRuntimeException(RuntimeException ex, WebRequest request) {
        return new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );
    }

    // Maneja cualquier otro error inesperado (Error 500)
    @ExceptionHandler(Exception.class)
    public ErrorMessage handleGlobalException(Exception ex, WebRequest request) {
        return new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now(),
                "Ocurrió un error inesperado en el servidor",
                request.getDescription(false)
        );
    }
}