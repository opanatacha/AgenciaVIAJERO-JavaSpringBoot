package com.example.agenciaviajerojavaspringboot.controller;

import com.example.agenciaviajerojavaspringboot.model.Pedido;
import com.example.agenciaviajerojavaspringboot.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    //Persistência
    @PostMapping("/compra")
    public String savePedido(@ModelAttribute ("pedido") Pedido pedido){
        Pedido savedPedido = pedidoService.savePedido(pedido);
        return "redirect:/pedido/pedido_form/" + savedPedido.getIdPedido();
    }

    @GetMapping("/pedido_form/{idPedido}")
    public String showPedidoForm(@PathVariable ("idPedido") Integer idPedido, Model model){
        Pedido pedido = pedidoService.getPedidoById(idPedido);
        model.addAttribute("pedido", pedido);
        return "pedido_form";
    }

    //Mostrar o form de novo pedido da compra
    @GetMapping("/nova_compra")
    public String showFormAdd(Model model){
        Pedido pedido = new Pedido();
        model.addAttribute("pedido", pedido);
        return "pedido";
    }

    //Mostrar o form de edição de pedido do usuario
    @GetMapping("/editar/{idPedido}")
    public String showFormUpdate(@PathVariable Integer idPedido, Model model){
        Pedido pedido = pedidoService.getPedidoById(idPedido);
        model.addAttribute("pedido", pedido);
        return "editar_pedido";

    }

    @PostMapping("/editar/{idPedido}")
    public String updadePedido(@PathVariable Integer idPedido, @ModelAttribute ("pedido") Pedido pedido){
        pedidoService.updatePedido(idPedido , pedido);
        return "redirect:/pedido/pedido_form/" + idPedido;
    }

    //Exclusão de pedido
    @GetMapping("/deletar/{idPedido}")
    public String deletePedido(@PathVariable Integer idPedido){
        pedidoService.deletePedido(idPedido);
        return "redirect:/index.html";
    }

}
