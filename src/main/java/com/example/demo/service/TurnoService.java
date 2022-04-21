package com.example.demo.service;

//import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.TurnoDTO;
import com.example.demo.persistence.entities.Turno;
import com.example.demo.persistence.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ImplService<TurnoDTO>{

    private ITurnoRepository turnoRepository;

    @Autowired
    public void setTurnoRepository(ITurnoRepository turnoRepository){
        this.turnoRepository = turnoRepository;
    }

    @Autowired
    ObjectMapper mapper;

    @Override
    public TurnoDTO save(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);

        TurnoDTO turnoDTO1 = mapper.convertValue(turnoRepository.save(turno), TurnoDTO.class);

        return turnoDTO1;
    }

    @Override
    public Set<TurnoDTO> findAll() {
        List<Turno> turnoList = turnoRepository.findAll();
        Set<TurnoDTO> turnoDTOList = new HashSet<>();

        for (Turno turno : turnoList) {
            turnoDTOList.add(mapper.convertValue(turno, TurnoDTO.class));
        }

        return turnoDTOList;
    }

    @Override
    public void deleteById(Integer id) /*throws NotFoundException*/ {
        if (findById(id) != null)
            turnoRepository.deleteById(id);
    }

    @Override
    public TurnoDTO findById(Integer id) /*throws NotFoundException*/{
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if (turno.isPresent()){
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        } /*else {
            throw new NotFoundException("No existe un turno con el id:" + id);
        }*/

        return turnoDTO;
    }

    @Override
    public TurnoDTO update(TurnoDTO turnoDTO) {
        return save(turnoDTO);
    }
}
