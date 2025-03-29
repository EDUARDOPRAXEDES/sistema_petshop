package com.petshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vendas")
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long quantidade;
    private Long cliente_id;
    private Long animais_id;
    private Long vendedores_id;
    private Long pedido_id;
    private Long produto_id;



    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long id) {
        this.quantidade = id;
    }

    public Long getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Long produto_id) {
        this.produto_id = produto_id;
    }

    public Long getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Long pedido_id) {
        this.pedido_id = pedido_id;
    }

    public Long getVendedores_id() {
        return vendedores_id;
    }

    public void setVendedores_id(Long vendedores_id) {
        this.vendedores_id = vendedores_id;
    }

    public Long getAnimais_id() {
        return animais_id;
    }

    public void setAnimais_id(Long animais_id) {
        this.animais_id = animais_id;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Object getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}