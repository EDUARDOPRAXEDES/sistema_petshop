package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.petshop.model.Pagamento;
import com.petshop.services.PagamentoService;





@Controller
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/pagamento")
    public String listarPagamento(Model model) {
        model.addAttribute("pagamento", pagamentoService.buscarTodosOsPagamento());
        return "pagamento/lista";
    }

    @GetMapping("/pagamento/realizar")
    public String exibirFormularioRealizarPagamento() {
        return "pagamento/realizar";
    }

    @PostMapping("/pagamento")
    public String salvarPagamento(Pagamento pagamento) {
        pagamentoService.salvarPagamento(pagamento);
        return "redirect:/pagamento";
    }

    @GetMapping("/pagamento/editar/{id}")
    public String editarPagamento(@PathVariable Long id, Model model) {
        Pagamento pagamento = pagamentoService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("pagamento", pagamento);
        return "pagamento/editar";
    }

    @PostMapping("/pagamento/editar/{id}")
    public String atualizarPagamento(@PathVariable Long id, @ModelAttribute Pagamento pagamentoAtualizado) {
        Pagamento pagamento = pagamentoService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        pagamento.setId(id);
        pagamentoAtualizado.getId();
        pagamento.setValor_pago(null);
        pagamentoAtualizado.getValor_pago();

    
        return "redirect:/pagamento";
    }

    @GetMapping("/pagamento/deletar/{id}")
    public String deletarPagamento(@PathVariable Long id) {
        pagamentoService.excluirPagamentoPorId(id);
        return "redirect:/pagamento";
    }


}
