/*package com.example.demo;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.OdontologoDTO;
import com.example.demo.service.OdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class OdontologoTest {

    private OdontologoService odontologoService;
    @Autowired
    public void setOdontologoService(OdontologoService odontologoService){
        this.odontologoService = odontologoService;
    }

    @Autowired
    ObjectMapper mapper;


    @Test
    void crearYBuscarOdontologo() throws NotFoundException {
        OdontologoDTO odontologoDto1 = new OdontologoDTO("Vilma", "Carbajo", 845114);
        OdontologoDTO odontologoCreado = odontologoService.save(odontologoDto1);

        Assertions.assertTrue(odontologoService.findById(odontologoCreado.getId()) != null);
    }

    @Test
    void actualizarOdontologo(){
        OdontologoDTO odontologoDto1 = new OdontologoDTO("Marina", "Winzer", 900114);
        OdontologoDTO odontologoCreado = odontologoService.save(odontologoDto1);

        odontologoCreado.setApellido("Luna");
        odontologoService.update(odontologoCreado);

        Assertions.assertTrue(odontologoCreado.getApellido() == "Luna");
    }
}*/