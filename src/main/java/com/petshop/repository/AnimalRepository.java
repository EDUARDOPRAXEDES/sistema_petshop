package com.petshop.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.petshop.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("SELECT a FROM Animal a JOIN FETCH a.raca")
    List<Animal> findAllComRaca();

}