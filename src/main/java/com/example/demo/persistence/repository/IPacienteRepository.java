package com.example.demo.persistence.repository;

import com.example.demo.persistence.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {

    @Query(
            value= "select * from pacientes p where p.domicilio_id = :domicilio_id",
            nativeQuery = true)
    Optional<Paciente> getPacienteByDomicilioId(@Param("domicilio_id") Integer id);

}
