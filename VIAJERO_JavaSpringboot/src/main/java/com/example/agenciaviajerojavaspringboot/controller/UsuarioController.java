package com.example.agenciaviajerojavaspringboot.controller;
import com.example.agenciaviajerojavaspringboot.model.Usuario;
import com.example.agenciaviajerojavaspringboot.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    //Persistência
    @PostMapping("/cadastro")
    public String saveUsuario(@ModelAttribute("usuario") Usuario usuario){
        Usuario savedUsuario = usuarioService.saveUsuario(usuario);
        return "redirect:/usuario/usuario_perfil/" + savedUsuario.getIdUsuario();
        }

    @GetMapping("/usuario_perfil/{idUsuario}")
    public String showUsuarioPerfil(@PathVariable("idUsuario") Integer idUsuario, Model model){
        Usuario usuario = usuarioService.getUsuarioById(idUsuario);
        model.addAttribute("usuario", usuario);
        return "usuario_perfil";
    }

    //Mostrar o form de novo cadastro de usuário
    @GetMapping("/novo")
    public String showFormAdd(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "cadastro";
    }

    //Mostrar o form de edição de perfil do usuário
    @GetMapping("/editar/{idUsuario}")
    public String showFormUpdate(@PathVariable Integer idUsuario, Model model){
        Usuario usuario = usuarioService.getUsuarioById(idUsuario);
        model.addAttribute("usuario", usuario);
        return "editar_usuario";
    }

    @PostMapping("/editar/{idUsuario}")
    public String updadeUsuario(@PathVariable Integer idUsuario, @ModelAttribute ("usuario") Usuario usuario){
        usuarioService.updateUsuario(idUsuario , usuario);
        return "redirect:/usuario/usuario_perfil/" + idUsuario;
    }

    //Exclusão de usuário
    @GetMapping("/deletar/{idUsuario}")
    public String deleteUsuario(@PathVariable Integer idUsuario){
        usuarioService.deleteUsuario(idUsuario);
        return "redirect:/index.html";
    }



}



















