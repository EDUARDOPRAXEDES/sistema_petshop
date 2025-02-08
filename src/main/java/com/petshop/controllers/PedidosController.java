package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.petshop.model.Pedidos;
import com.petshop.services.PedidosService;


@Controller
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @GetMapping("/pedidos")
    public String listarPedidos(Model model) {
        model.addAttribute("pedidos", pedidosService.buscarTodosOsPedidos());
        return "pedidos/lista";
    }

    @GetMapping("/pedidos/realizar")
    public String exibirFormularioRealizarPedido() {
        return "pedidos/realizar";
    }

    

    @PostMapping("/pedidos")
    public String salvarPedidos(Pedidos pedidos) {
        pedidosService.salvarPedidos(pedidos);
        return "redirect:/pedidos";
    
    }

@GetMapping("/pedidos/editar/{id}")
public String editarPedidos(@PathVariable Long id, Model model) {
    Pedidos pedidos = pedidosService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
    model.addAttribute("pedidos", pedidos);
    return "pedidos/editar";
}

@PostMapping("/pedidos/editar/{id}")
public String atualizarPedidos(@PathVariable Long id, @ModelAttribute Pedidos pedidosAtualizado) {
    Pedidos pedidos = pedidosService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
    pedidos.setNumero_pedido(id);pedidosAtualizado.getNumero_pedido();
    
    
    
    return "redirect:/pedidos";
}

@GetMapping("/pedidos/deletar/{id}")
public String deletarPedidos(@PathVariable Long id) {
    pedidosService.excluirPedidosPorId(id);
    return "redirect:/pedidos";
}


}