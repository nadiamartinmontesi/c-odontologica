package com.example.demo;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.DomicilioDTO;
import com.example.demo.model.PacienteDTO;
import com.example.demo.persistence.entities.Domicilio;
import com.example.demo.service.DomicilioService;
import com.example.demo.service.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;


@SpringBootTest
class PacienteServiceTest {

    private PacienteService pacienteService;
    @Autowired
    public void setPacienteService(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @Autowired
    ObjectMapper mapper;


   @Test
    void crearYBuscarTodosLosPacientes(){
        PacienteDTO pacienteDTO1 = new PacienteDTO("Mike", "James","23675980", new Date(2021,11,20),mapper.convertValue(new DomicilioDTO("Rivadavia", "6521", "caba", "caba"), Domicilio.class));
        pacienteService.save(pacienteDTO1);

        PacienteDTO pacienteDTO2 = new PacienteDTO("Lourdes", "Bandana","16576589", new Date(2020,04,12),mapper.convertValue(new DomicilioDTO("Triunvirato", "2312", "caba", "caba"), Domicilio.class));
        pacienteService.save(pacienteDTO2);

        PacienteDTO pacienteDTO3 = new PacienteDTO("Juan", "Caruso","30980129", new Date(2022,02,19),mapper.convertValue(new DomicilioDTO("Juramento", "4630", "caba", "caba"), Domicilio.class));
        pacienteService.save(pacienteDTO3);


        Assertions.assertNotNull(pacienteService.findAll());

    }

    @Test
    void eliminarPaciente() throws NotFoundException {
        PacienteDTO pacienteDTO1 = new PacienteDTO("Pablo", "Picasso","45786900", new Date(2021,9,10),mapper.convertValue(new DomicilioDTO("Cullen", "5445", "caba", "caba"), Domicilio.class));
        PacienteDTO pacienteDtoCreado1 = pacienteService.save(pacienteDTO1);

        PacienteDTO pacienteDTO2 = new PacienteDTO("Micaela", "Tevez","32342832", new Date(2021,06,26),mapper.convertValue(new DomicilioDTO("Mendoza", "2456", "caba", "caba"), Domicilio.class));
        PacienteDTO pacienteDtoCreado2 = pacienteService.save(pacienteDTO2);

        pacienteService.deleteById(pacienteDtoCreado2.getId());

        Assertions.assertThrows(NotFoundException.class, ()-> {pacienteService.findById(pacienteDtoCreado2.getId());});
    }

}