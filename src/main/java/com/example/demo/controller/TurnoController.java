package com.example.demo.controller;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.exceptions.TurnoBeforeDateException;
import com.example.demo.model.TurnoDTO;
import com.example.demo.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping("/turnos")
//@CrossOrigin(origins = "*") para el cors del front
public class TurnoController {

    Date fechaActual = new Date(System.currentTimeMillis());

    private TurnoService turnoService;

    @Autowired
    public void setTurnoService(TurnoService turnoService){
        this.turnoService = turnoService;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody TurnoDTO turnoDTO) throws TurnoBeforeDateException {
        if (turnoDTO.getFechaTurno().before(fechaActual)){
            throw new TurnoBeforeDateException("Debe elegir una fecha futura para crear un turno.");
        } else {
            turnoService.save(turnoDTO);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Turno creado");
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> findById(@PathVariable Integer id) throws NotFoundException{
        return ResponseEntity.ok(turnoService.findById(id));
    }

    @PutMapping
    public ResponseEntity<TurnoDTO> update(TurnoDTO turnoDTO) throws NotFoundException {
        ResponseEntity<TurnoDTO> response = null;

        if (turnoDTO.getId() != null && turnoService.findById(turnoDTO.getId()) != null){
            response = ResponseEntity.ok(turnoService.update(turnoDTO));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) throws NotFoundException{
        turnoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
    }

    @GetMapping
    public ResponseEntity<Set<TurnoDTO>> findAll(){
        if (turnoService.findAll() != null){
            return ResponseEntity.ok(turnoService.findAll());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @ExceptionHandler({TurnoBeforeDateException.class})
    public ResponseEntity procesarErrorFechaPasada(TurnoBeforeDateException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
