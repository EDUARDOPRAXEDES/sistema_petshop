package com.petshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.model.Produto;
import com.petshop.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Listar todos os produto
    public List<Produto> buscarTodosOsProdutos() {
        return produtoRepository.findAll();
    }

    public void salvarProdutos(Produto produto) {
        produtoRepository.save(produto);
    }

    // Buscar um produto por ID
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    // Deletar um produto
    public void excluirProdutoPorId(Long id) {
        produtoRepository.deleteById(id);
    }

    // Editar cliente (atualizar suas informações)
    public Produto atualizarProduto(Produto produto) {
        if (produto.getId() != null) {
            return produtoRepository.save(produto);  // aqui chamamos o método save acima
        }
        return null;
    }
    }


