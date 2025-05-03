package com.petshop.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numero_pedido;
    private Calendar data_hora;

    @OneToMany(mappedBy = "pedidos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vendas> vendas = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_clientes_id")
    private Cliente cliente;

    public Pedidos(Long numero_pedido, Calendar data_hora) {
        this.numero_pedido = numero_pedido;
        this.data_hora = data_hora;
    }

    public Pedidos() {
    }

    public Long getNumero_pedido() {
        return numero_pedido;
    }

    public void setNumero_pedido(Long numero_pedido) {
        this.numero_pedido = numero_pedido;
    }

    public Calendar getData_hora() {
        return data_hora;
    }

    public void setData_hora(Calendar data_hora) {
        this.data_hora = data_hora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}