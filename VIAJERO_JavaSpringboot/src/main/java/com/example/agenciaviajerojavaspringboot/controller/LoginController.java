package com.example.agenciaviajerojavaspringboot.controller;

import com.example.agenciaviajerojavaspringboot.model.Usuario;
import com.example.agenciaviajerojavaspringboot.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("email", "");
        model.addAttribute("senha", "");
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String senha){
        Usuario usuario = loginService.autenticar(email, senha);


        if (usuario != null) {
         return "redirect:/usuario/usuario_perfil/" + usuario.getIdUsuario();
        }

        return "redirect:/login?error=true";

    }

}
