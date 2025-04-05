package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.petshop.model.Categoria;
import com.petshop.services.CategoriaService;




@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoria")
    public String listarCategoria(Model model) {
        model.addAttribute("categoria", categoriaService.buscarTodosOsCategoria());
        return "categoria/lista";
    }

    @GetMapping("/categoria/cadastro")
    public String exibirFormularioRealizarCategoria() {
        return "categoria/cadastro";
    }

    @PostMapping("/categoria")
    public String salvarCategoria(Categoria categoria) {
        categoriaService.salvarCategoria(categoria);
        return "redirect:/categoria";
    }

    @GetMapping("/categoria/editar/{id}")
    public String editarCategoria(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("categoria", categoria);
        return "categoria/editar";
    }

    @PostMapping("/categoria/editar/{id}")
    public String atualizarCategoria(@PathVariable Long id, @ModelAttribute Categoria categoriaAtualizado) {
        Categoria categoria = categoriaService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        categoria.setNome(categoriaAtualizado.getNome());
        categoriaService.salvarCategoria(categoria);
        
        return "redirect:/categoria";
    }

    @GetMapping("/categoria/deletar/{id}")
    public String deletarCategoria(@PathVariable Long id) {
        categoriaService.excluirCategoriaPorId(id);
        return "redirect:/categoria";
    }
}
