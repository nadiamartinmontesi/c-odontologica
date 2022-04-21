package com.example.demo.service;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.DomicilioDTO;
import com.example.demo.model.PacienteDTO;
import com.example.demo.persistence.entities.Domicilio;
import com.example.demo.persistence.entities.Paciente;
import com.example.demo.persistence.repository.IDomicilioRepository;
import com.example.demo.persistence.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class PacienteService implements ImplService<PacienteDTO>{

    private IDomicilioRepository domicilioRepository;

    @Autowired
    public void setDomicilioRepository(IDomicilioRepository domicilioRepository){
        this.domicilioRepository = domicilioRepository;
    }

    private IPacienteRepository pacienteRepository;

    @Autowired
    public void setPacienteRepository(IPacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    @Autowired
    ObjectMapper mapper;

    @Override
    public PacienteDTO save(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);

        Paciente pacienteGuardado = pacienteRepository.save(paciente);

        PacienteDTO pacienteDTO1 = mapper.convertValue(pacienteGuardado, PacienteDTO.class);

        return pacienteDTO1;
    }

    @Override
    public Set<PacienteDTO> findAll() {
        List<Paciente> pacienteList = pacienteRepository.findAll();
        Set<PacienteDTO> pacienteDTOList = new HashSet<>();

        for (Paciente paciente : pacienteList) {
            pacienteDTOList.add(mapper.convertValue(paciente, PacienteDTO.class));
        }

        return pacienteDTOList;
    }

    @Override
    public void deleteById(Integer id) throws NotFoundException {
        if (findById(id) != null)
            pacienteRepository.deleteById(id);
    }

    @Override
    public PacienteDTO findById(Integer id) throws NotFoundException{
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if (paciente.isPresent()){
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }else {
            throw new NotFoundException("No existe un paciente con el id:" + id);
        }

        return pacienteDTO;
    }

    @Override
    public PacienteDTO update(PacienteDTO pacienteDTO) {
        return save(pacienteDTO);
    }
}
