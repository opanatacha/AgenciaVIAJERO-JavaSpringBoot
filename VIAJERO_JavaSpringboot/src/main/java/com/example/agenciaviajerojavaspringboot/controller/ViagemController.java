package com.example.agenciaviajerojavaspringboot.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import com.example.agenciaviajerojavaspringboot.model.Viagem;
import com.example.agenciaviajerojavaspringboot.services.ViagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/viagem", method = RequestMethod.GET)
@ResponseStatus(HttpStatus.OK)
public class ViagemController {

    @Autowired
    private ViagemService viagemService;

    //Persistência de dados da viagem / destino
    @PostMapping("/cadastro_viagem")
    public String saveViagem(@ModelAttribute("viagem") Viagem viagem){
       Viagem savedViagem = viagemService.saveViagem(viagem);
       return "redirect:/viagem/viagem_form/" + savedViagem.getIdViagem();
    }

    @GetMapping("/viagem_form/{idViagem}")
    public String showViagemForm(@PathVariable("idViagem") Integer idViagem, Model model){
        Viagem viagem = viagemService.getViagemById(idViagem);
        model.addAttribute("viagem", viagem);
        return "viagem_form";
    }

    @GetMapping(value = "/lista_viagens")
    @ResponseBody
    public String showViagemList(Model model) {
        List<Viagem> viagens = viagemService.getAllViagens();
        model.addAttribute("viagens", viagens);
        return "lista_viagens";
    }

    //Mostrar a tela de cadastro de novas viagens
    @GetMapping("/nova_viagem")
    public String showFormAdd(Model model){
        Viagem viagem = new Viagem();
        model.addAttribute("viagem", viagem);
        return "cadastro_viagem";
    }

    //Mostrar o form de edição de viagem / destino
    @GetMapping("/editar/{idViagem}")
    public String showFormUpdate(@PathVariable Integer idViagem, Model model){
        Viagem viagem = viagemService.getViagemById(idViagem);
        model.addAttribute("viagem", viagem);
        return "editar_viagem";
    }

    @PostMapping("/editar/{idViagem}")
    public String updadeViagem(@PathVariable Integer idViagem, @ModelAttribute ("viagem") Viagem viagem){
        viagemService.updateViagem(idViagem , viagem);
        return "redirect:/viagem/viagem_form/" + idViagem;
    }

    //Exclusão de viagem / destino
    @GetMapping("/deletar/{idViagem}")
    public String deleteViagem(@PathVariable Integer idViagem){
        viagemService.deleteViagem(idViagem);
        return "redirect:/index.html";
    }



}
