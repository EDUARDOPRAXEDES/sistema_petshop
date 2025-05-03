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
@Table(name = "vendas")
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantidade;
    private Long cliente_id;
    private Long animais_id;
    private Long vendedores_id;
    private Long pedido_id;
    private Long produto_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_clientes_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "fk_animais_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "fk_vendedores_id")
    private Vendedores vendedores;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_pedidos_id")
    private Pedidos pedidos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_produtos_id")
    private Produto produto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Long getAnimais_id() {
        return animais_id;
    }

    public void setAnimais_id(Long animais_id) {
        this.animais_id = animais_id;
    }

    public Long getVendedores_id() {
        return vendedores_id;
    }

    public void setVendedores_id(Long vendedores_id) {
        this.vendedores_id = vendedores_id;
    }

    public Long getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Long pedido_id) {
        this.pedido_id = pedido_id;
    }

    public Long getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Long produto_id) {
        this.produto_id = produto_id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Vendedores getVendedores() {
        return vendedores;
    }

    public void setVendedores(Vendedores vendedores) {
        this.vendedores = vendedores;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}