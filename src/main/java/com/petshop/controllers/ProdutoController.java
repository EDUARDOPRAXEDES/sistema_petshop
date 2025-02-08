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

import com.petshop.model.Produto;
import com.petshop.services.ProdutoService;


@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoService.buscarTodosOsProdutos());
        return "produtos/lista";
    }

    @GetMapping("/produtos/cadastro")
    public String exibirFormularioCadastro() {
        return "produtos/cadastro";
    }

   

    @PostMapping("/produtos")
    public String salvarProduto(@ModelAttribute Produto produto, @RequestParam("foto") MultipartFile foto, String imagesPath, String imagensPath) throws IOException{
        if (!foto.isEmpty()) {
            if (!foto.isEmpty()){
                String nomeArquivo = foto.getOriginalFilename();
                String caminhoRelativo = "/imagens/produtos/" + nomeArquivo;
                Path caminhoAbsoluto = Paths.get(imagensPath + nomeArquivo);
                Files.copy(foto.getInputStream(), caminhoAbsoluto);
                produto.setFotoPath(caminhoRelativo); 
            }
        }
        produtoService.salvarProdutos(produto);
        return "redirect:/produtos";
    }

@GetMapping("/produtos/editar/{id}")
public String atualizarProduto(@PathVariable Long id, @ModelAttribute Produto produtoAtualizado) {
    Produto produto = produtoService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
    produto.setNome(produtoAtualizado.getNome());
    produto.setCategoria(produtoAtualizado.getCategoria());
    produto.setPreco(produtoAtualizado.getPreco());
    produtoService.salvarProdutos(produto);
    return "redirect:/produtos";
}
@GetMapping("/produtos/deletar/{id}")
public String deletarProduto(@PathVariable Long id) {
    produtoService.excluirProdutoPorId(id);
    return "redirect:/produtos";

}
}