package com.hotel.reservas.testInfraestructura;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.reservas.ReservasApplication;
import com.hotel.reservas.aplicacion.comando.ComandoReserva;
import com.hotel.reservas.dominio.modelo.dto.PersonasDto;
import com.hotel.reservas.dominio.modelo.entidad.Habitaciones;
import com.hotel.reservas.dominio.modelo.entidad.Reserva;

import com.hotel.reservas.dominio.puerto.repositorio.RepositorioReserva;

import com.hotel.reservas.infraestructura.adaptador.repositorio.entidades.HabitacionEntidad;
import com.hotel.reservas.infraestructura.cliente.PersonasCliente;
import com.hotel.reservas.infraestructura.repositorioJpa.HabitacionRepositorioJpa;
import com.hotel.reservas.testDominio.HabitacionDataBuilder;
import com.hotel.reservas.testDominio.ReservaDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ReservasApplication.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ControladorReservaTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;


    private PersonasCliente personasCliente;
    @Autowired
    RepositorioReserva repositorioReserva;
    @Autowired
    HabitacionRepositorioJpa habitacionRepositorioJpa;
    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
    @Test
    @DisplayName("Deberia guardar correctamente la reserva")

    public void guardarReserva() throws Exception {


        ComandoReserva comandoReserva=new ComandoReservaDataBuilder().build();
        mockMvc.perform(post("http://localhost:8091/reservas").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoReserva))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }
    @Test
    @DisplayName("Deberia consultar todas las reservas")
    public void consultarTodos() throws Exception {
        /*Reserva reserva = new ReservaDataBuilder().build();
        repositorioReserva.save(reserva);
        personasCliente = Mockito.mock(PersonasCliente.class);
        PersonasDto personasDto=new PersonasDto(1234,"juan","calle 12",123456,"juan@juan");
        Mockito.when(personasCliente.buscarPorId(reserva.getIdPersona()).getBody()).thenReturn(personasDto);*/
        mockMvc.perform(get("http://localhost:8091/reservas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$", hasSize(5)))
                .andDo(print());
    }
    @Test
    @DisplayName("Deberia consultar la reserva por el id")
    public void consultarPorId() throws Exception {
        /*Reserva reserva = new ReservaDataBuilder().build();
        repositorioReserva.save(reserva);
        personasCliente = Mockito.mock(PersonasCliente.class);
        PersonasDto personasDto=new PersonasDto(reserva.getIdPersona(),"juan","calle 12",123456,"juan@juan");
        Mockito.when(personasCliente.buscarPorId(reserva.getIdPersona()).getBody()).thenReturn(personasDto);*/
        mockMvc.perform(get("http://localhost:8091/reservas/{id}",27)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idPersona", is(123456)))
                .andExpect(jsonPath("$.dias", is(1)))
                .andDo(print());
    }
    @Test
    @DisplayName("Deberia devolver un not found por que ese id no existe")
    public void consultarPorIdNoExistente() throws Exception {
        Reserva reserva = new ReservaDataBuilder().build();
        repositorioReserva.save(reserva);
        mockMvc.perform(get("http://localhost:8091/reservas/{id}",11)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(print());
    }
    @Test
    @DisplayName("Deberia consultar la habitacion por el estado")
    public void consultarHbitacionPorId() throws Exception {
        /*Habitaciones habitaciones=new HabitacionDataBuilder().build();
        HabitacionEntidad habitacionEntidad=new HabitacionEntidad(habitaciones.getIdHabitacion(),habitaciones.getCapacidad(),habitaciones.getNumeroCamas(),habitaciones.getPrecio(),habitaciones.getEstado());
        habitacionRepositorioJpa.save(habitacionEntidad);*/
        mockMvc.perform(get("http://localhost:8091/reservas/habitaciones/{id}","libre")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idHabitacion", is(101)))
                .andExpect(jsonPath("$[0].estado", is("libre")))
                .andExpect(jsonPath("$[0].capacidad", is(1)))
                .andExpect(jsonPath("$[0].precio", is(25000.0)))
                .andExpect(jsonPath("$[0].numeroCamas", is(2.0)))
                .andDo(print());
    }
}
