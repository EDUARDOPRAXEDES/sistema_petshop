package com.petshop.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.petshop.model.Animal;
import com.petshop.model.Especie;
import com.petshop.model.Raca;
import com.petshop.services.AnimalService;
import com.petshop.services.ClienteService;
import com.petshop.services.RacaService;
import com.petshop.services.EspecieService;


@Controller
public class AnimalController {

    private final EspecieService especieService;

    @Autowired
    private AnimalService animalService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private RacaService racaService;

    @Value("${imagens.animais.path}")
    private String imagesPath;

    AnimalController(EspecieService especieService) {
        this.especieService = especieService;
    }

    @GetMapping("/animais")
    public String listarAnimais(Model model) {
        model.addAttribute("animais", animalService.buscarTodosOsAnimais());
        return "animais/lista";
    }
    
    @GetMapping("animais/cadastro")
    public String exibirFormularioCadastro(Model model) {
       
        model.addAttribute("clientes", clienteService.buscarTodosOsClientes());
        model.addAttribute("racas", racaService.buscarTodasAsRaca());
        model.addAttribute("especie", especieService.buscarTodosOsEspecie());
        return "animais/cadastro";
    }

    @GetMapping("/animais/editar/{id}")
    public String editarAnimal(@PathVariable Long id, Model model) {
        Animal animal = animalService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("animal", animal);
        
        List<Raca> racas= racaService.buscarTodasAsRaca();
        model.addAttribute("racas", racas);


        return "animais/editar";
    }

    @PostMapping("/animais/editar/{id}")
    public String atualizarAnimal(@PathVariable Long id, @ModelAttribute Animal animalAtualizado) {
        Animal animal = animalService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        animal.setNome(animalAtualizado.getNome());
        animal.setRaca(animalAtualizado.getRaca());
        animal.setIdade(animalAtualizado.getIdade());
        animalService.salvarAnimal(animal);
        return "redirect:/animais";
    }

    @GetMapping("/animais/deletar/{id}")
    public String deletarAnimal(@PathVariable Long id) {
        animalService.excluirAnimalPorId(id);
        return "redirect:/animais";
    }


    @PostMapping("/animais")
    public String salvarAnimal(@ModelAttribute Animal animal, 
                @RequestParam("especieId") Long especieId,
                 @RequestParam("foto") MultipartFile foto) throws IOException {

        Especie especie = especieService.buscarPorId(especieId);
        if (!foto.isEmpty()) {
            String nomeArquivo = foto.getOriginalFilename(); 
            Path caminho = Paths.get(imagesPath + nomeArquivo);
            Files.copy(foto.getInputStream(), caminho);
            animal.setFotoPath(caminho.toString());
        }
        animalService.salvarAnimal(animal);
        return "redirect:/animais";
    }

}