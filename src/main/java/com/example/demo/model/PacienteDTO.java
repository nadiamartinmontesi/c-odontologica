package com.example.demo.model;

import com.example.demo.persistence.entities.Domicilio;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class PacienteDTO {

    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;
    private Domicilio domicilio;

    public PacienteDTO() {
    }

    public PacienteDTO(String nombre, String apellido, String dni, Date fechaIngreso, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public PacienteDTO(Integer id, String nombre, String apellido, String dni, Date fechaIngreso, Domicilio domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }
}
