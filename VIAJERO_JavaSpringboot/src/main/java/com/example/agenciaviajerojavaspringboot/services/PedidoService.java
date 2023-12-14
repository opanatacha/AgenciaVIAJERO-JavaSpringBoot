package com.example.agenciaviajerojavaspringboot.services;
import com.example.agenciaviajerojavaspringboot.model.Pedido;
import java.util.List;

public interface PedidoService {

    Pedido savePedido(Pedido pedido);

    Pedido getPedidoById(Integer idPedido);

    List<Pedido> getAllPedidos();

    Pedido updatePedido(Integer idPedido ,Pedido pedido);

    void deletePedido(Integer idPedido);

}
