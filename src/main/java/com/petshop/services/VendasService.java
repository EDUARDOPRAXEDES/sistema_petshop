package com.petshop.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.model.Vendas;
import com.petshop.repository.VendasRepository;

@Service
public class VendasService {

    @Autowired
    private VendasRepository vendasRepository;

    // Listar todas as vendas
    public List<Vendas> buscarTodosAsVendas() {
        return vendasRepository.findAll();
    }

    public void salvarVendas(Vendas vendas) {
        vendasRepository.save(vendas);
    }

    // Buscar uma venda por ID
    public Optional<Vendas> buscarPorId(Long id) {
        return vendasRepository.findById(id);
    }

    // Deletar uma venda
    public void excluirVendasPorId(Long id) {
        vendasRepository.deleteById(id);
    }

    // Editar venda (atualizar suas informações)
    public Vendas atualizarVendas(Vendas vendas) {
        if (vendas.getId() != null) {
            return vendasRepository.save(vendas);  // aqui chamamos o método save acima
        }
        return null;
    }
}
