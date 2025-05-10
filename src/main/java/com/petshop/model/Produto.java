package com.petshop.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double preco;
    private String fotoPath;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria; // Correção: Agora está correto

    @OneToMany(mappedBy = "produto")
    private List<Vendas> vendas;

    public Produto(Long id, String nome, double preco, Categoria categoria, String fotoPath) { // Correção aqui
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.fotoPath = fotoPath;
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

    public Categoria getCategoria() { // Getter corrigido
        return categoria;
    }

    public void setCategoria(Categoria categoria) { // Setter corrigido
        this.categoria = categoria;
    }

    public String getFotoPath() {
        return fotoPath;
    }

    public void setFotoPath(String fotoPath) {
        this.fotoPath = fotoPath;
    }
}
