package com.example.demo.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString

@Entity
@Table(name="Turno")
public class Turno {

    @Id
    @SequenceGenerator(name="turno_sequence", sequenceName = "turno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "odontologo_id", nullable = false)
    private Odontologo odontologo;

    private Date fechaTurno;

    public Turno() {
    }

    public Turno(Paciente paciente, Odontologo odontologo, Date fechaTurno) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaTurno = fechaTurno;
    }

    public Turno(Integer id, Paciente paciente, Odontologo odontologo, Date fechaTurno) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaTurno = fechaTurno;
    }
}
