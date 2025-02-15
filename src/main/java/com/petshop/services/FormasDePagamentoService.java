package com.petshop.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.model.FormasDePagamento;
import com.petshop.repository.FormasDePagamentoRepository;




@Service
public class FormasDePagamentoService {

    @Autowired
    private FormasDePagamentoRepository formasDePagamentoRepository;


    public List<FormasDePagamento> buscarTodasAsFormasDePagamento() {
        return formasDePagamentoRepository.findAll();
    }

    public void salvarFormaDePagamento(FormasDePagamento formaDePagamento) {
        formasDePagamentoRepository.save(formaDePagamento);
    }

   
    public Optional<FormasDePagamento> buscarPorId(Long id) {
        return formasDePagamentoRepository.findById(id);
    }

    
    public void excluirFormaDePagamentoPorId(Long id) {
        formasDePagamentoRepository.deleteById(id);
    }

    
    public FormasDePagamento atualizarFormaDePagamento(FormasDePagamento formaDePagamento) {
        if (formaDePagamento.getId() != null) {
            return formasDePagamentoRepository.save(formaDePagamento);
        }
        return null;
    }
}
