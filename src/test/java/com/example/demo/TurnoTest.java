package com.example.demo;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.DomicilioDTO;
import com.example.demo.model.OdontologoDTO;
import com.example.demo.model.PacienteDTO;
import com.example.demo.model.TurnoDTO;
import com.example.demo.persistence.entities.Domicilio;
import com.example.demo.persistence.entities.Odontologo;
import com.example.demo.persistence.entities.Paciente;
import com.example.demo.service.OdontologoService;
import com.example.demo.service.PacienteService;
import com.example.demo.service.TurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;


@SpringBootTest
class TurnoTest {

    private TurnoService turnoService;
    @Autowired
    public void setTurnoService(TurnoService turnoService){
        this.turnoService = turnoService;
    }

    private PacienteService pacienteService;
    @Autowired
    public void setPacienteService(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    private OdontologoService odontologoService;
    @Autowired
    public void setOdontologoService(OdontologoService odontologoService){
        this.odontologoService = odontologoService;
    }

    @Autowired
    ObjectMapper mapper;

  @Test
    void crearYBuscarTurno() throws NotFoundException {

        PacienteDTO pacienteDto1 = new PacienteDTO("Julian", "Rios", "32569874", new Date(2022,04,02), mapper.convertValue(new DomicilioDTO("Monroe", "5241", "caba", "caba"), Domicilio.class));
        PacienteDTO pacienteCreado = pacienteService.save(pacienteDto1);

        OdontologoDTO odontologoDto1 = new OdontologoDTO("Susana", "Morales", 568410);
        OdontologoDTO odontologoCreado = odontologoService.save(odontologoDto1);

        TurnoDTO turnoDto1 = new TurnoDTO(mapper.convertValue(pacienteCreado, Paciente.class), mapper.convertValue(odontologoCreado, Odontologo.class), new Date(2022,05,10));
        TurnoDTO turnoCreado = turnoService.save(turnoDto1);

        Assertions.assertTrue(turnoService.findById(turnoCreado.getId()) != null);
    }

    @Test
    void eliminarTurno() throws NotFoundException {

        PacienteDTO pacienteDto1 = new PacienteDTO("Marcos", "Diaz", "12900899", new Date(2020,02,27), mapper.convertValue(new DomicilioDTO("Arcos", "2576", "caba", "caba"), Domicilio.class));
        PacienteDTO pacienteCreado = pacienteService.save(pacienteDto1);

        OdontologoDTO odontologoDto1 = new OdontologoDTO("Cecilia", "Rosales", 676876);
        OdontologoDTO odontologoCreado = odontologoService.save(odontologoDto1);

        TurnoDTO turnoDto1 = new TurnoDTO(mapper.convertValue(pacienteCreado, Paciente.class), mapper.convertValue(odontologoCreado, Odontologo.class), new Date(2022,05,16));
        TurnoDTO turnoCreado = turnoService.save(turnoDto1);

        turnoService.deleteById(turnoCreado.getId());

        Assertions.assertThrows(NotFoundException.class, ()-> {turnoService.findById(turnoCreado.getId());});
    }

}