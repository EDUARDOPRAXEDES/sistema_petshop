package com.petshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.model.Pedidos;
import com.petshop.repository.PedidosRepository;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    // Listar todos os pedidos
    public List<Pedidos> buscarTodosOsPedidos() {
        return pedidosRepository.findAll();
    }

    public void salvarPedidos(Pedidos pedidos) {
        pedidosRepository.save(pedidos);
    }

    // Buscar um pedido por ID
    public Optional<Pedidos> buscarPorId(Long id) {
        return pedidosRepository.findById(id);
    }

    // Deletar um pedido
    public void excluirPedidosPorId(Long id) {
        pedidosRepository.deleteById(id);
    }

    // Editar cliente (atualizar suas informações)
    public Pedidos atualizarPedidos(Pedidos pedidos) {
        if (pedidos.getId() != null) {
            return pedidosRepository.save(pedidos);  // aqui chamamos o método save acima
        }
        return null;
    }
    }