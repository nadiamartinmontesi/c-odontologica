package com.example.demo.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name="Pacientes")
public class Paciente {

    @Id
    @SequenceGenerator(name="paciente_sequence", sequenceName = "paciente_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;

    @OneToOne
    @JoinColumn(name="domicilio_id", referencedColumnName = "id", nullable = false)
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Turno> turnos;

    public Paciente() {
    }

    public Paciente(String nombre, String apellido, String dni, Date fechaIngreso, Domicilio domicilio, Set<Turno> turnos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
        this.turnos = turnos;
    }

    public Paciente(Integer id, String nombre, String apellido, String dni, Date fechaIngreso, Domicilio domicilio, Set<Turno> turnos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
        this.turnos = turnos;
    }
}
