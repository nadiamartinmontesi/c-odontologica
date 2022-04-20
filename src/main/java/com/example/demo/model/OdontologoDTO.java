package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OdontologoDTO {

    private Integer id;
    private String nombre;
    private String apellido;
    private Integer matricula;

    public OdontologoDTO() {
    }

    public OdontologoDTO(String nombre, String apellido, Integer matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public OdontologoDTO(Integer id, String nombre, String apellido, Integer matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
}
