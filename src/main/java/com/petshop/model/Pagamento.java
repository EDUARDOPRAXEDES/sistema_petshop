package com.petshop.model;
import java.util.ArrayList;
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
@Table(name="pagamento")
public class Pagamento {

     @OneToMany(mappedBy = "pagamento")
    private List<FormasDePagamento> formasDePagamentos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "formas_de_pagamento_id")
    private FormasDePagamento formaDePagamento;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedores vendedor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valor_pago;
    

    public Double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(Double valor_pago) {
        this.valor_pago = valor_pago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FormasDePagamento getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(FormasDePagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public Vendedores getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedores vendedor) {
        this.vendedor = vendedor;
    }

}
