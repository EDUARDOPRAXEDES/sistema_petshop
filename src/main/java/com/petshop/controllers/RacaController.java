package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.petshop.model.Raca;
import com.petshop.services.RacaService;



@Controller
public class RacaController {

    @Autowired
    private RacaService racaService;

    @GetMapping("/raca")
    public String listarRaca(Model model) {
        model.addAttribute("raca", racaService.buscarTodasAsRaca());
        return "raca/lista";
    }

    @GetMapping("/raca/cadastro")
    public String exibirFormularioRealizarRaca() {
        return "raca/cadastro";
    }

    @PostMapping("/raca")
    public String salvarRaca(Raca raca) {
        racaService.salvarRaca(raca);
        return "redirect:/raca";
    }

    @GetMapping("/raca/editar/{id}")
    public String editarRaca(@PathVariable Long id, Model model) {
        Raca raca = racaService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("raca", raca);
        return "raca/editar";
    }

    @PostMapping("/raca/editar/{id}")
    public String atualizarRaca(@PathVariable Long id, @ModelAttribute Raca racaAtualizada) {
        Raca raca = racaService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        raca.setId(id);
        racaAtualizada.getId();
        raca.setNome(null);
        racaAtualizada.getNome();

        return "redirect:/raca";
    }

    @GetMapping("/raca/deletar/{id}")
    public String deletarRaca(@PathVariable Long id) {
        racaService.excluirRacaPorId(id);
        return "redirect:/raca";
    }
}




