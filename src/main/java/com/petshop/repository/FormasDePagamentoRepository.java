package com.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshop.model.FormasDePagamento;


@Repository
public interface FormasDePagamentoRepository extends JpaRepository<FormasDePagamento, Long> {}