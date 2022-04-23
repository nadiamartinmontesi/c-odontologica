package com.example.demo.persistence.repository;

import com.example.demo.persistence.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
    //@Query("from Pacientes p where p.domicilio_id = :domicilio_id")
    //Optional<Paciente> gePacienteByDomicilioId(@Param("domicilio_id") Integer idDomicilio);
    //probarrrrrrrr
}
