package com.example.demo.controller;


import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.PacienteDTO;
import com.example.demo.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/pacientes")
//@CrossOrigin(origins = "*") para el cors del front
public class PacienteController {

    private PacienteService pacienteService;

    @Autowired
    public void setPacienteService(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> save(@RequestBody PacienteDTO pacienteDTO) {

        return ResponseEntity.ok(pacienteService.save(pacienteDTO));

    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> findById(@PathVariable Integer id) throws NotFoundException{
        return ResponseEntity.ok(pacienteService.findById(id));
    }

    @PutMapping
    public ResponseEntity<PacienteDTO> update(@RequestBody PacienteDTO pacienteDTO) throws NotFoundException {
        ResponseEntity<PacienteDTO> response = null;

        if (pacienteDTO.getId() != null && pacienteService.findById(pacienteDTO.getId()) != null)
            response = ResponseEntity.ok(pacienteService.update(pacienteDTO));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) throws NotFoundException{
        pacienteService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
    }

    @GetMapping
    public ResponseEntity<Set<PacienteDTO>> findAll(){
        if (pacienteService.findAll() != null) {
            return ResponseEntity.ok(pacienteService.findAll());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
