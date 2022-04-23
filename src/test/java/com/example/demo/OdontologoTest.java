package com.example.demo;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.OdontologoDTO;
import com.example.demo.service.OdontologoService;
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

    @Test
    void crearYBuscarOdontologo() throws NotFoundException {
        OdontologoDTO odontologoCreado = odontologoService.save(new OdontologoDTO("Vilma", "Carbajo", 845114));

        Assertions.assertTrue(odontologoService.findById(odontologoCreado.getId()) != null);
    }

    @Test
    void actualizarOdontologo(){
        OdontologoDTO odontologoCreado = odontologoService.save(new OdontologoDTO("Marina", "Winzer", 900114));

        odontologoCreado.setApellido("Luna");
        odontologoService.update(odontologoCreado);

        Assertions.assertTrue(odontologoCreado.getApellido() == "Luna");
    }
}