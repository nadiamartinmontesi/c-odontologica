package com.example.demo.model;

import com.example.demo.persistence.entities.Odontologo;
import com.example.demo.persistence.entities.Paciente;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class TurnoDTO {

    private Integer id;
    private Paciente paciente;
    private Odontologo odontologo;
    private Date fechaTurno;

    public TurnoDTO() {
    }

    public TurnoDTO(Paciente paciente, Odontologo odontologo, Date fechaTurno) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaTurno = fechaTurno;
    }

    public TurnoDTO(Integer id, Paciente paciente, Odontologo odontologo, Date fechaTurno) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaTurno = fechaTurno;
    }
}
