package com.petshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="animais")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String fotoPath;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente dono;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "raca_id")
    private Raca raca;


    public Animal() {
    }

    public Animal(String nome, Raca raca, int idade, String fotoPath) { // Correção: Agora aceita um objeto Raca
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.fotoPath = fotoPath;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getFotoPath() {
        return fotoPath;
    }

    public void setFotoPath(String fotoPath) {
        this.fotoPath = fotoPath;
    }

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public Raca getRaca() { // Adicionando getter para Raca
        return raca;
    }

    public void setRaca(Raca raca) { // Adicionando setter para Raca
        this.raca = raca;
    }
}
