package com.example.demo.persistence.repository;

import com.example.demo.persistence.entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio, Integer> {
}
