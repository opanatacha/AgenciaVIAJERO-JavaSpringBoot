package com.example.agenciaviajerojavaspringboot.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;

    @Column
    private int numPedido;

    @Column
    private Date dataPedido;

    @Column
    private String formaPagamento;

    @Column
    private float valorTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idViagem")
    private Viagem viagem;

    public Pedido() {

    }

    public Pedido(int idPedido, int numPedido, Date dataPedido, String formaPagamento, float valorTotal, Usuario usuario, Viagem viagem) {
        this.idPedido = idPedido;
        this.numPedido = numPedido;
        this.dataPedido = dataPedido;
        this.formaPagamento = formaPagamento;
        this.valorTotal = valorTotal;
        this.usuario = usuario;
        this.viagem = viagem;
    }


    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }
}
