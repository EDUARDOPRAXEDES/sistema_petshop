package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.petshop.model.FormasDePagamento;
import com.petshop.services.FormasDePagamentoService;





@Controller
public class FormasDePagamentoController {

    @Autowired
    private FormasDePagamentoService formasDePagamentoService;

    @GetMapping("/formasdepagamento")
    public String listarFormasDePagamento(Model model) {
        model.addAttribute("formasdepagamento", formasDePagamentoService.buscarTodasAsFormasDePagamento());
        return "formasdepagamento/lista";
    }

    @GetMapping("/formasdepagamento/cadastro")
    public String exibirFormularioRealizarFormasDePagamento() {
        return "formasdepagamento/cadastro";
    }

    @PostMapping("/formasdepagamento")
    public String salvarFormasDePagamento(FormasDePagamento formasDePagamento) {
        formasDePagamentoService.salvarFormaDePagamento(formasDePagamento);
        return "redirect:/formasdepagamento";
    }

    @GetMapping("/formasdepagamento/editar/{id}")
    public String editarFormasDePagamento(@PathVariable Long id, Model model) {
        FormasDePagamento formasDePagamento = formasDePagamentoService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("formasdepagamento", formasDePagamento);
        return "formasdepagamento/editar";
    }

    @PostMapping("/formasdepagamento/editar/{id}")
    public String atualizarFormasDePagamento(@PathVariable Long id, @ModelAttribute FormasDePagamento formasDePagamentoAtualizado) {
        FormasDePagamento formasDePagamento = formasDePagamentoService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        formasDePagamento.setId(id);
        formasDePagamentoAtualizado.getId();
        formasDePagamento.setDescricao(null);
        formasDePagamentoAtualizado.getDescricao();

        return "redirect:/formasdepagamento";
    }

    @GetMapping("/formasdepagamento/deletar/{id}")
    public String deletarFormasDePagamento(@PathVariable Long id) {
        formasDePagamentoService.excluirFormaDePagamentoPorId(id);
        return "redirect:/formasdepagamento";
    }

}