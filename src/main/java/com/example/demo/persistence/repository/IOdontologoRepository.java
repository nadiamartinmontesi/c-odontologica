package com.example.demo.persistence.repository;

import com.example.demo.persistence.entities.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Integer> {
    //@Query("select o from Odontologos o where o.nombre = ?1")
    //List<Odontologo> getOdontologosByNombre(String nombre);


}
