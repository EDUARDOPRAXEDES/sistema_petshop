package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.petshop.model.Raca;
import com.petshop.services.RacaService;
import com.petshop.services.EspecieService;

@Controller
public class RacaController {

    @Autowired
    private RacaService racaService;

    @Autowired
    private EspecieService especieService;

    @GetMapping("/raca")
    public String listarRaca(Model model) {
        model.addAttribute("raca", racaService.buscarTodasAsRaca()); 
        return "raca/lista";
    }

    @GetMapping("/raca/cadastro")
    public String exibirFormularioCadastroRaca(Model model) {
        model.addAttribute("raca", new Raca());
        model.addAttribute("especies", especieService.buscarTodosOsEspecie()); 
        return "raca/cadastro";
    }

    @PostMapping("/raca")
    public String salvarRaca(@ModelAttribute Raca raca) {
        racaService.salvarRaca(raca);
        return "redirect:/raca";
    }

    @GetMapping("/raca/editar/{id}")
    public String editarRaca(@PathVariable Long id, Model model) {
        Raca raca = racaService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("raca", raca);
        model.addAttribute("especies", especieService.buscarTodosOsEspecie()); 
        return "raca/editar";
    }

    @PostMapping("/raca/editar/{id}")
    public String atualizarRaca(@PathVariable Long id, @ModelAttribute Raca racaAtualizada) {
        Raca raca = racaService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));

        raca.setNome(racaAtualizada.getNome());
        raca.setEspecie(racaAtualizada.getEspecie());

        racaService.salvarRaca(raca);
        return "redirect:/raca";
    }

    @GetMapping("/raca/deletar/{id}")
    public String deletarRaca(@PathVariable Long id) {
        racaService.excluirRacaPorId(id);
        return "redirect:/raca";
    }
}
