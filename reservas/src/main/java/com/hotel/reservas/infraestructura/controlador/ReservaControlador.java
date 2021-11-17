package com.hotel.reservas.infraestructura.controlador;

import com.hotel.reservas.aplicacion.comando.ComandoReserva;
import com.hotel.reservas.aplicacion.comando.manejador.ManejadorCrearReserva;
import com.hotel.reservas.aplicacion.consulta.ManejadorConsultaReservaPorId;
import com.hotel.reservas.aplicacion.consulta.ManejadorConsultaReservaPorIdPersona;
import com.hotel.reservas.aplicacion.consulta.ManejadorConsultarHabitaciones;
import com.hotel.reservas.aplicacion.consulta.ManejadorConsultarReservas;
import com.hotel.reservas.dominio.modelo.dto.HabitacionesDto;
import com.hotel.reservas.dominio.modelo.dto.ReservaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaControlador {
    private final ManejadorConsultaReservaPorId manejadorConsultaReservaPorId;
    private final ManejadorConsultarHabitaciones manejadorConsultarHabitaciones;
    private final ManejadorConsultarReservas manejadorConsultarReservas;
    private final ManejadorCrearReserva manejadorCrearReserva;
    private final ManejadorConsultaReservaPorIdPersona manejadorConsultaReservaPorIdPersona;

    public ReservaControlador(ManejadorConsultaReservaPorId manejadorConsultaReservaPorId, ManejadorConsultarHabitaciones manejadorConsultarHabitaciones, ManejadorConsultarReservas manejadorConsultarReservas, ManejadorCrearReserva manejadorCrearReserva, ManejadorConsultaReservaPorIdPersona manejadorConsultaReservaPorIdPersona) {
        this.manejadorConsultaReservaPorId = manejadorConsultaReservaPorId;
        this.manejadorConsultarHabitaciones = manejadorConsultarHabitaciones;
        this.manejadorConsultarReservas = manejadorConsultarReservas;
        this.manejadorCrearReserva = manejadorCrearReserva;

        this.manejadorConsultaReservaPorIdPersona = manejadorConsultaReservaPorIdPersona;
    }

    @GetMapping

    public ResponseEntity<List<ReservaDto>> gettodos(){
        return new ResponseEntity<>(manejadorConsultarReservas.ejecutar(), HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<ReservaDto>getReserva(@PathVariable("id") Long idReserva) {

        return  manejadorConsultaReservaPorId.ejecutar(idReserva).map(reserva ->
                new ResponseEntity<>(reserva,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void crear(@RequestBody ComandoReserva comandoReserva) {
        manejadorCrearReserva.ejecutar(comandoReserva);
    }

    @GetMapping(value = "/habitaciones/{id}")
    public ResponseEntity<List<HabitacionesDto>> getHabitaciones(@PathVariable("id") String estado) {
        return new ResponseEntity<>(manejadorConsultarHabitaciones.ejecutar(estado), HttpStatus.OK);
    }
    @GetMapping(value = "/personas/{id}")
    public ResponseEntity<List<ReservaDto>> getHabitaciones(@PathVariable("id") int id) {
        return  manejadorConsultaReservaPorIdPersona.ejecutar(id).map(reserva ->
                new ResponseEntity<>(reserva,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
