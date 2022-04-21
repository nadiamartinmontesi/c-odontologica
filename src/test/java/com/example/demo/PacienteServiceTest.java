/*package com.example.demo;

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

    private DomicilioService domicilioService;
    @Autowired
    public void setDomicilioService(DomicilioService domicilioService){
        this.domicilioService = domicilioService;
    }

    @Autowired
    ObjectMapper mapper;


   @Test
    void crearYBuscarTodosLosPacientes(){
        DomicilioDTO domicilioDto1 = new DomicilioDTO("Rivadavia", "6521", "caba", "caba");
        DomicilioDTO domicilioDtoCreado1 = domicilioService.save(domicilioDto1);

        PacienteDTO pacienteDTO1 = new PacienteDTO("Mike", "James","23675980", new Date(2021,11,20),mapper.convertValue(domicilioDtoCreado1, Domicilio.class));
        pacienteService.save(pacienteDTO1);


        DomicilioDTO domicilioDto2 = new DomicilioDTO("Triunvirato", "2312", "caba", "caba");
        DomicilioDTO domicilioDtoCreado2 = domicilioService.save(domicilioDto2);

        PacienteDTO pacienteDTO2 = new PacienteDTO("Lourdes", "Bandana","16576589", new Date(2020,04,12),mapper.convertValue(domicilioDtoCreado2, Domicilio.class));
        pacienteService.save(pacienteDTO2);


        DomicilioDTO domicilioDto3 = new DomicilioDTO("Juramento", "4630", "caba", "caba");
        DomicilioDTO domicilioDtoCreado3 = domicilioService.save(domicilioDto3);

        PacienteDTO pacienteDTO3 = new PacienteDTO("Juan", "Caruso","30980129", new Date(2022,02,19),mapper.convertValue(domicilioDtoCreado3, Domicilio.class));
        pacienteService.save(pacienteDTO3);


        Assertions.assertNotNull(pacienteService.findAll());

    }

    @Test
    void eliminarPaciente() throws NotFoundException {
        DomicilioDTO domicilioDto1 = new DomicilioDTO("Cullen", "5445", "caba", "caba");
        DomicilioDTO domicilioDtoCreado1 = domicilioService.save(domicilioDto1);

        PacienteDTO pacienteDTO1 = new PacienteDTO("Pablo", "Picasso","45786900", new Date(2021,9,10),mapper.convertValue(domicilioDtoCreado1, Domicilio.class));
        PacienteDTO pacienteDtoCreado1 = pacienteService.save(pacienteDTO1);


        DomicilioDTO domicilioDto2 = new DomicilioDTO("Mendoza", "2456", "caba", "caba");
        DomicilioDTO domicilioDtoCreado2 = domicilioService.save(domicilioDto2);

        PacienteDTO pacienteDTO2 = new PacienteDTO("Micaela", "Tevez","32342832", new Date(2021,06,26),mapper.convertValue(domicilioDtoCreado2, Domicilio.class));
        PacienteDTO pacienteDtoCreado2 = pacienteService.save(pacienteDTO2);

        pacienteService.deleteById(pacienteDtoCreado2.getId());

        Assertions.assertThrows(NotFoundException.class, ()-> {pacienteService.findById(pacienteDtoCreado2.getId());});
    }

}*/