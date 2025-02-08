package com.petshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.model.Vendedores;
import com.petshop.repository.VendedoresRepository;




@Service
public class VendedoresService {

        @Autowired
    private VendedoresRepository vendedoresRepository;

    // Listar todos os vendedores
    public List<Vendedores> buscarTodosOsVendedores() {
        return vendedoresRepository.findAll();
    }

    public void salvarVendedores(Vendedores vendedor) {
        vendedoresRepository.save(vendedor);
    }

    // Buscar um vendedor por ID
    public Optional<Vendedores> buscarPorId(Long id) {
        return vendedoresRepository.findById(id);
    }

    // Deletar um vendedor
    public void excluirVendedoresPorId(Long id) {
        vendedoresRepository.deleteById(id);
    }

    // Editar cliente (atualizar suas informações)
    public Vendedores atualizarVendedores(Vendedores vendedores) {
        if (vendedores.getId() != null) {
            return vendedoresRepository.save(vendedores);
        }
        return null;
    }

}
