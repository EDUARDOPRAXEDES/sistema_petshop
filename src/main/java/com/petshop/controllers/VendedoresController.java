package com.petshop.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.petshop.model.Vendedores;
import com.petshop.services.VendedoresService;



@Controller

public class VendedoresController {

    @Autowired
    private VendedoresService vendedoresService;

    @GetMapping("/vendedores")
    public String listarProdutos(Model model) {
        model.addAttribute("vendedores", vendedoresService.buscarTodosOsVendedores());
        return "produtos/lista";
    }

    @GetMapping("/vendedores/cadastro")
    public String exibirFormularioCadastro() {
        return "vendedores/cadastro";
    }

   

    @PostMapping("/vendedores")
    public String salvarVendedores(@ModelAttribute Vendedores vendedores, @RequestParam("foto") MultipartFile foto, String imagesPath, String imagensPath) throws IOException{
        if (!foto.isEmpty()) {
            if (!foto.isEmpty()){
                String nomeArquivo = foto.getOriginalFilename();
                String caminhoRelativo = "/imagens/vendedores/" + nomeArquivo;
                Path caminhoAbsoluto = Paths.get(imagensPath + nomeArquivo);
                Files.copy(foto.getInputStream(), caminhoAbsoluto);
                vendedores.setFotoPath(caminhoRelativo); 
            }
        }
        vendedoresService.salvarVendedores(vendedores);
        return "redirect:/vendedores";
    }

@GetMapping("/vendedores/editar/{id}")
public String atualizarVendedores(@PathVariable Long id, @ModelAttribute Vendedores vendedoresAtualizado) {
    Vendedores vendedores = vendedoresService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
    vendedores.setNome(vendedoresAtualizado.getNome());
    vendedores.setIdade(vendedoresAtualizado.getIdade());
    vendedores.setCpf(vendedoresAtualizado.getCpf());
    vendedores.setTelefone(vendedoresAtualizado.getTelefone());
    vendedores.setFotoPath(vendedoresAtualizado.getFotoPath());
    vendedoresService.salvarVendedores(vendedores);
    return "redirect:/vendedores";
}
@GetMapping("/vendedores/deletar/{id}")
public String deletarVendedores(@PathVariable Long id) {
    vendedoresService.excluirVendedoresPorId(id);
    return "redirect:/vendedores";

}
}
