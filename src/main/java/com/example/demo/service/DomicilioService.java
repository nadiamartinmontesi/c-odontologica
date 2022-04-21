package com.example.demo.service;


//import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.DomicilioDTO;
import com.example.demo.persistence.entities.Domicilio;
import com.example.demo.persistence.repository.IDomicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class DomicilioService implements ImplService<DomicilioDTO> {

    private IDomicilioRepository domicilioRepository;

    @Autowired
    public void setDomicilioRepository(IDomicilioRepository domicilioRepository){
        this.domicilioRepository = domicilioRepository;
    }

    @Autowired
    ObjectMapper mapper;

    @Override
    public DomicilioDTO save(DomicilioDTO domicilioDTO) {

        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);

        DomicilioDTO domicilioDTO1 = mapper.convertValue(domicilioRepository.save(domicilio), DomicilioDTO.class);

        return domicilioDTO1;

    }

    @Override
    public Set<DomicilioDTO> findAll() {
        List<Domicilio> domicilioList = domicilioRepository.findAll();
        Set<DomicilioDTO> domicilioDTOList = new HashSet<>();

        for (Domicilio domicilio : domicilioList) {
            domicilioDTOList.add(mapper.convertValue(domicilio, DomicilioDTO.class));
        }

        return domicilioDTOList;
    }

    @Override
    public void deleteById(Integer id) /*throws NotFoundException*/{
        if (findById(id) != null)
            domicilioRepository.deleteById(id);
    }

    @Override
    public DomicilioDTO findById(Integer id) /*throws NotFoundException*/{

        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        DomicilioDTO domicilioDTO = null;
        if (domicilio.isPresent()){
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
        } /*else {
            throw new NotFoundException("No existe un domicilio con el id:" + id);
        }*/

        return domicilioDTO;

    }

    @Override
    public DomicilioDTO update(DomicilioDTO domicilioDTO) {
        return save(domicilioDTO);
    }
}
