package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DomicilioDTO {

    private Integer id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    public DomicilioDTO() {
    }

    public DomicilioDTO(String calle, String numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public DomicilioDTO(Integer id, String calle, String numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }
}
