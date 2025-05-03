package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.petshop.model.Vendas;
import com.petshop.services.VendasService;

@Controller
public class VendasController {

    @Autowired
    private VendasService vendasService;

    @GetMapping("/vendas")
    public String listarVendas(Model model) {
        model.addAttribute("vendas", vendasService.buscarTodosAsVendas());
        return "vendas/lista";
    }

    @GetMapping("/vendas/realizar")
    public String exibirFormularioRealizarVendas() {
        return "vendas/realizar";
    }

    @PostMapping("/vendas")
    public String salvarVendas(Vendas vendas) {
        vendasService.salvarVendas(vendas);
        return "redirect:/vendas";
    }

    @GetMapping("/vendas/editar/{id}")
    public String editarVendas(@PathVariable Long id, Model model) {
        Vendas vendas = vendasService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("vendas", vendas);
        return "vendas/editar";
    }

    @PostMapping("/vendas/editar/{id}") // Passar numero do pedido como id
    public String atualizarVendas(@PathVariable Long id, @ModelAttribute Vendas vendasAtualizado) {
        Vendas vendas = vendasService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        vendas.setQuantidade(vendasAtualizado.getQuantidade());

        vendasService.salvarVendas(vendas);

        return "redirect:/vendas";
    }

    @GetMapping("/vendas/deletar/{id}")
    public String deletarVendas(@PathVariable Long id) {
        vendasService.excluirVendasPorId(id);
        return "redirect:/vendas";
    }
}
