package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.petshop.model.Cliente;
import com.petshop.services.ClienteService;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.buscarTodosOsClientes());
        return "clientes/lista";
    }

    @GetMapping("/clientes/cadastro")
    public String exibirFormularioCadastro() {
        return "clientes/cadastro";
    }

    

    @PostMapping("/clientes")
    public String salvarCliente(Cliente cliente) {
        clienteService.salvarCliente(cliente);
        return "redirect:/clientes";
    
    }

@GetMapping("/clientes/editar/{id}")
public String editarCliente(@PathVariable Long id, Model model) {
    Cliente cliente = clienteService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
    model.addAttribute("cliente", cliente);
    return "clientes/editar";
}

@PostMapping("/clientes/editar/{id}")
public String atualizarCliente(@PathVariable Long id, @ModelAttribute Cliente clienteAtualizado) {
    Cliente cliente = clienteService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
    cliente.setNome(clienteAtualizado.getNome());
    cliente.setEmail(clienteAtualizado.getEmail());
    cliente.setTelefone(clienteAtualizado.getTelefone());
    cliente.setEndereco(clienteAtualizado.getEndereco());
    cliente.setCpf(clienteAtualizado.getCpf());
    clienteService.salvarCliente(cliente);
    return "redirect:/clientes";
}

@GetMapping("/clientes/deletar/{id}")
public String deletarCliente(@PathVariable Long id) {
    clienteService.excluirClientePorId(id);
    return "redirect:/clientes";
}


}