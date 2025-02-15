package com.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshop.model.Raca;





@Repository
public interface RacaRepository extends JpaRepository<Raca, Long> {}