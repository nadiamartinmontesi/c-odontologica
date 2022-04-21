package com.example.demo.service;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.OdontologoDTO;
import com.example.demo.model.PacienteDTO;
import com.example.demo.persistence.entities.Odontologo;
import com.example.demo.persistence.entities.Paciente;
import com.example.demo.persistence.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService implements ImplService<OdontologoDTO>{

    private IOdontologoRepository odontologoRepository;
    @Autowired
    public void setOdontologoRepository(IOdontologoRepository odontologoRepository){
        this.odontologoRepository = odontologoRepository;
    }

    @Autowired
    ObjectMapper mapper;

    @Override
    public OdontologoDTO save(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);

        OdontologoDTO odontologoDtoCreado = mapper.convertValue(odontologoRepository.save(odontologo), OdontologoDTO.class);

        return odontologoDtoCreado;
    }

    @Override
    public Set<OdontologoDTO> findAll() {
        List<Odontologo> odontologoList = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTOList = new HashSet<>();

        for (Odontologo odontologo : odontologoList) {
            odontologoDTOList.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }

        return odontologoDTOList;
    }



    @Override
    public OdontologoDTO findById(Integer id) throws NotFoundException{
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if (odontologo.isPresent()) {
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        } else {
            throw new NotFoundException("No existe un odontólogo con el id:" + id);
        }

        return odontologoDTO;
    }

    @Override
    public void deleteById(Integer id) throws NotFoundException{
        if (findById(id) != null)
            odontologoRepository.deleteById(id);
    }

    @Override
    public OdontologoDTO update(OdontologoDTO odontologoDTO) {
        return save(odontologoDTO);
    }

    /*public List<Odontologo> getOdontologosByNombre(String nombre){
        return odontologoRepository.getOdontologosByNombre(nombre);
    }*/
}
