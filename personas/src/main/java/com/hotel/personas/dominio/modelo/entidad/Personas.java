package com.hotel.personas.dominio.modelo.entidad;



import com.hotel.personas.dominio.validador.ValidadorDeArgumento;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Personas {
    private static  final String EL_NOMBRE_ES_OBLIGATORIO="el nombre es obligatorio";
    private static  final String EL_ID_ES_OBLIGATORIO="el id es obligatorio";
    private static  final String EL_ID_DEBE_SER_MAYOR_O_MENOR="el id debe ser mayor a 5 y menor que 10";
    private static  final String EL_EMAIL_ES_OBLIGATORIO="el email es obligatorio";
    private int id;
    private String nombre;
    private String direccion;
    private int telefono;
    private String email;

    public Personas(int id, String nombre, String direccion, int telefono, String email) {
        ValidadorDeArgumento.validarObligatorio(nombre,EL_NOMBRE_ES_OBLIGATORIO);
        ValidadorDeArgumento.validarLongitud(id,EL_ID_DEBE_SER_MAYOR_O_MENOR);
        ValidadorDeArgumento.validarObligatorio(email,EL_EMAIL_ES_OBLIGATORIO);
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }


}
