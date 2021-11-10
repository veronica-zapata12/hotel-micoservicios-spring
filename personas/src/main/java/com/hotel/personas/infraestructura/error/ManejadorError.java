package com.hotel.personas.infraestructura.error;

import com.hotel.personas.dominio.excepcion.ExcepcionCampoObligatorio;
import com.hotel.personas.dominio.excepcion.ExcepcionDuplicidad;
import com.hotel.personas.dominio.excepcion.ExcepcionGeneral;
import com.hotel.personas.dominio.excepcion.ExcepcionLongitud;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class ManejadorError extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManejadorError.class);

    private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "OcurriÃ³ un error favor contactar al administrador.";

    private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

    public ManejadorError() {

        CODIGOS_ESTADO.put(ExcepcionCampoObligatorio.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionDuplicidad.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionGeneral.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionLongitud.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());

    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<com.hotel.personas.infraestructura.error.Error> handleAllExceptions(Exception exception) {
        ResponseEntity<com.hotel.personas.infraestructura.error.Error> resultado;

        String excepcionNombre = exception.getClass().getSimpleName();
        String mensaje = exception.getMessage();
        Integer codigo = CODIGOS_ESTADO.get(excepcionNombre);

        if (codigo != null) {
            com.hotel.personas.infraestructura.error.Error error = new com.hotel.personas.infraestructura.error.Error(excepcionNombre, mensaje);
            resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
        } else {
            LOGGER.error(excepcionNombre, exception);
            com.hotel.personas.infraestructura.error.Error error = new com.hotel.personas.infraestructura.error.Error(excepcionNombre, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
            resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resultado;
    }
}
