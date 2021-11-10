package com.hotel.personas.testInfraestructura;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.personas.PersonasApplication;
import com.hotel.personas.aplicacion.comando.ComandoPersona;
import com.hotel.personas.dominio.modelo.entidad.Personas;
import com.hotel.personas.dominio.puerto.repositorio.RepositorioPersonas;
import com.hotel.personas.testDominio.PersonaDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
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
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PersonasApplication.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControladoPersonasTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    RepositorioPersonas repositorioPersonas;
    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    @DisplayName("Deberia guardar correctamente la persona")
    public void guardarPersona() throws Exception {


        ComandoPersona comandoPersona=new ComandoPersonaDataBuilder().conId(12324).build();
        mockMvc.perform(post("http://localhost:8090/personas").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoPersona))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }
    @Test
    @DisplayName("Deberia consultar todas las personas")
    public void consultarTodos() throws Exception {
        Personas personas = new PersonaDataBuilder().build();
        repositorioPersonas.crear(personas);
        mockMvc.perform(get("http://localhost:8090/personas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andDo(print());
    }
    @Test
    @DisplayName("Deberia consultar la persona por el id")
    public void consultarPorId() throws Exception {
        Personas personas = new PersonaDataBuilder().build();
        repositorioPersonas.crear(personas);
        mockMvc.perform(get("http://localhost:8090/personas/{id}",1234567)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1234567)))
                .andExpect(jsonPath("$.nombre", is("juan")))
                .andDo(print());
    }
}
