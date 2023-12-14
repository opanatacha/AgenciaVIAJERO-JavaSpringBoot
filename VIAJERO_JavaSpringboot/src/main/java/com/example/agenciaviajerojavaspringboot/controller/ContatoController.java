package com.example.agenciaviajerojavaspringboot.controller;
import com.example.agenciaviajerojavaspringboot.model.Contato;
import com.example.agenciaviajerojavaspringboot.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping("/cadastro")
    public String saveContato(@ModelAttribute ("contato") Contato contato) {
        contatoService.saveContato(contato);
        return "redirect:/index.html";

    }

    @GetMapping("/novo")
    public String showFormAdd(Model model){
        Contato contato = new Contato();
        model.addAttribute("contato", contato);
        return "contato";
    }

}
