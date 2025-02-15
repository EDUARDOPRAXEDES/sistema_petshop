package com.petshop.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.model.Categoria;
import com.petshop.repository.CategoriaRepository;


@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Listar todas as categorias
    public List<Categoria> buscarTodosOsCategoria() {
        return categoriaRepository.findAll();
    }

    public void salvarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    // Buscar uma categoria por ID
    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    // Deletar uma categoria
    public void excluirCategoriaPorId(Long id) {
        categoriaRepository.deleteById(id);
    }

    // Editar categoria (atualizar suas informações)
    public Categoria atualizarCategoria(Categoria categoria) {
        if (categoria.getId() != null) {
            return categoriaRepository.save(categoria);  // aqui chamamos o método save acima
        }
        return null;
    }
}
