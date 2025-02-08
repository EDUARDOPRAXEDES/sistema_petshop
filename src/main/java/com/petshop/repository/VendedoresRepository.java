package com.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshop.model.Vendedores;

@Repository
public interface VendedoresRepository extends JpaRepository<Vendedores, Long> {}