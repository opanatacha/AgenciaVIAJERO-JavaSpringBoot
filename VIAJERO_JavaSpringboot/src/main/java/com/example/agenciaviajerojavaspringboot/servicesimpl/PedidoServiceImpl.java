package com.example.agenciaviajerojavaspringboot.servicesimpl;

import com.example.agenciaviajerojavaspringboot.model.Pedido;
import com.example.agenciaviajerojavaspringboot.repository.PedidoRepository;
import com.example.agenciaviajerojavaspringboot.services.PedidoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    @Transactional
    public Pedido getPedidoById(Integer idPedido) {
        return pedidoRepository.findById(idPedido).orElse(null);
    }

    @Override
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido updatePedido(Integer idPedido, Pedido pedidoAtualizado) {
        Pedido pedidoExistente = pedidoRepository.findById(idPedido).orElse(null);
        if (pedidoExistente != null) {
            pedidoExistente.setNumPedido(pedidoAtualizado.getNumPedido());
            pedidoExistente.setDataPedido(pedidoAtualizado.getDataPedido());
            pedidoExistente.setFormaPagamento(pedidoAtualizado.getFormaPagamento());
            pedidoExistente.setValorTotal(pedidoAtualizado.getValorTotal());
            pedidoExistente.setUsuario(pedidoAtualizado.getUsuario());
            pedidoExistente.setViagem(pedidoAtualizado.getViagem());
            return pedidoRepository.save(pedidoExistente);
        }else {
            throw new RuntimeException("Pedido " + idPedido + " não encontrado");
        }
    }

    @Override
    public void deletePedido(Integer idPedido) {
        pedidoRepository.deleteById(idPedido);
    }



}
