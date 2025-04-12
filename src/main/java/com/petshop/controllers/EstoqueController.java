package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.petshop.model.Estoque;
import com.petshop.services.EstoqueService;




@Controller
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping("/estoque")
    public String listarEstoque(Model model) {
        model.addAttribute("estoque", estoqueService.buscarTodosOsEstoque());
        return "estoque/lista";
    }

    @GetMapping("/estoque/cadastro")
    public String exibirFormularioRealizarEstoque() {
        return "estoque/cadastro";
    }

    @PostMapping("/estoque")
    public String salvarEstoque(Estoque estoque) {
        estoqueService.salvarEstoque(estoque);
        return "redirect:/estoque";
    }

    @GetMapping("/estoque/editar/{id}")
    public String editarEstoque(@PathVariable Long id, Model model) {
        Estoque estoque = estoqueService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("estoque", estoque);
        return "estoque/editar";
    }

    @PostMapping("/estoque/editar/{id}")
    public String atualizarEstoque(@PathVariable Long id, @ModelAttribute Estoque estoqueAtualizado) {
        Estoque estoque = estoqueService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        estoque.setId(id);
        estoqueAtualizado.getId();
        estoque.setQuantidade(id);
        estoqueAtualizado.getQuantidade();
        estoque.setData_entrada(null);
        estoqueAtualizado.getData_entrada();
        estoque.setNota_de_entrada(id);
        estoqueAtualizado.getNota_de_entrada();
        estoque.getValor_de_entrada();
        estoqueAtualizado.getValor_de_entrada();
    
        return "redirect:/estoque";
    }

    @GetMapping("/estoque/deletar/{id}")
    public String deletarEstoque(@PathVariable Long id) {
        estoqueService.excluirEstoquePorId(id);
        return "redirect:/estoque";
    }
}
