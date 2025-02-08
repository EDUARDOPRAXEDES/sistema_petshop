package com.petshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double preco;
    private String categoria;
    private String fotoPath; 

    public Produto(Long id, String nome, double preco, String categoria, String fotoPath) {
        this.categoria = categoria;
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Produto() {
    }

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFotoPath() {
        return fotoPath;
    }


    public void setFotoPath(String fotoPath) {
        this.fotoPath = fotoPath;
    }


    
    


}