package com.hotel.reservas.infraestructura.adaptador.repositorio.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservaEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long idReserva;
    @Column(name = "id_persona")
    private int idPersona;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_fin")
    private Date fechaFin;
    private int dias;
    private double total;
    @OneToOne(fetch =FetchType.LAZY )
    @JoinColumn(name="id_habitacion")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private HabitacionEntidad habitacionEntidad;
}
