package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.petshop.model.Especie;
import com.petshop.services.EspecieService;



@Controller
public class EspecieController {

    @Autowired
    private EspecieService especieService;

    @GetMapping("/especie")
    public String listarEspecie(Model model) {
        model.addAttribute("especie", especieService.buscarTodosOsEspecie());
        return "especie/lista";
    }

    @GetMapping("/especie/realizar")
    public String exibirFormularioRealizarEspecie() {
        return "especie/realizar";
    }

    @PostMapping("/especie")
    public String salvarEspecie(Especie especie) {
        especieService.salvarEspecie(especie);
        return "redirect:/especie";
    }

    @GetMapping("/especie/editar/{id}")
    public String editarEspecie(@PathVariable Long id, Model model) {
        Especie especie = especieService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("especie", especie);
        return "especie/editar";
    }

    @PostMapping("/especie/editar/{id}")
    public String atualizarEspecie(@PathVariable Long id, @ModelAttribute Especie especieAtualizada) {
        Especie especie = especieService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        especie.setId(id);
        especieAtualizada.getId();
        especie.setNome(null);
        especieAtualizada.getNome();

        return "redirect:/especie";
    }

    @GetMapping("/especie/deletar/{id}")
    public String deletarEspecie(@PathVariable Long id) {
        especieService.excluirEspeciePorId(id);
        return "redirect:/especie";
    }
}






