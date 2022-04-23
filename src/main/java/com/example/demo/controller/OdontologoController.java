package com.example.demo.controller;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.OdontologoDTO;
import com.example.demo.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/odontologos")
//@CrossOrigin(origins = "*") para el cors del front
public class OdontologoController {
    private OdontologoService odontologoService;

    @Autowired
    public void setOdontologoService (OdontologoService odontologoService){
        this.odontologoService = odontologoService;
    }

    @PostMapping()
    public ResponseEntity<OdontologoDTO> save(@RequestBody OdontologoDTO odontologoDTO) {

        return ResponseEntity.ok(odontologoService.save(odontologoDTO));

    }

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> findById(@PathVariable Integer id) throws NotFoundException{
        return ResponseEntity.ok(odontologoService.findById(id));
    }

    @PutMapping()
    public ResponseEntity<OdontologoDTO> update(@RequestBody OdontologoDTO odontologoDTO) throws NotFoundException{
        ResponseEntity<OdontologoDTO> response = null;

        if (odontologoDTO.getId() != null && odontologoService.findById(odontologoDTO.getId()) != null)
            response = ResponseEntity.ok(odontologoService.update(odontologoDTO));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) throws NotFoundException {
        odontologoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
    }

    @GetMapping
    public ResponseEntity<Set<OdontologoDTO>> findAll(){
        if (odontologoService.findAll() != null) {
            return ResponseEntity.ok(odontologoService.findAll());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
