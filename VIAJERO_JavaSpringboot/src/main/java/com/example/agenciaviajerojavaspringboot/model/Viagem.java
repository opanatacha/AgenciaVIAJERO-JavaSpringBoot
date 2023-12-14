package com.example.agenciaviajerojavaspringboot.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idViagem;

    @Column
    private String origem;

    @Column
    private String destino;

    @Column
    private LocalDate dataIda;

    @Column
    private LocalDate dataVolta;

    @Column
    private String tipoViagem;

    @Column
    private int qtdPessoas;

    @Column
    private String hospedagem;

    @Column
    private String tipoHospedagem;

    @Column
    private String enderecoHospedagem;

    @Column
    private String guiaTurismo;

    @Column
    private String agenciaTransporte;

    @Column
    private String codigoTransporte;

    @Column
    private String descricao;

    @Column
    private float valorViagem;

    @OneToMany(mappedBy = "viagem", fetch = FetchType.LAZY)
    private Set<Pedido> pedido;


    public Viagem() {

    }

    public Viagem(int idViagem, String origem, String destino, LocalDate dataIda, LocalDate dataVolta, String tipoViagem,
                  int qtdPessoas, String hospedagem, String tipoHospedagem, String enderecoHospedagem,
                  String guiaTurismo, String agenciaTransporte, String codigoTransporte, String descricao, float valorViagem) {
        this.idViagem = idViagem;
        this.origem = origem;
        this.destino = destino;
        this.dataIda = dataIda;
        this.dataVolta = dataVolta;
        this.tipoViagem = tipoViagem;
        this.qtdPessoas = qtdPessoas;
        this.hospedagem = hospedagem;
        this.tipoHospedagem = tipoHospedagem;
        this.enderecoHospedagem = enderecoHospedagem;
        this.guiaTurismo = guiaTurismo;
        this.agenciaTransporte = agenciaTransporte;
        this.codigoTransporte = codigoTransporte;
        this.descricao = descricao;
        this.valorViagem = valorViagem;
    }

    public int getIdViagem() {
        return idViagem;
    }

    public void setIdViagem(int idViagem) {
        this.idViagem = idViagem;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getDataIda() {
        return dataIda;
    }

    public void setDataIda(LocalDate dataIda) {
        this.dataIda = dataIda;
    }

    public LocalDate getDataVolta() {
        return dataVolta;
    }

    public void setDataVolta(LocalDate dataVolta) {
        this.dataVolta = dataVolta;
    }

    public String getTipoViagem() {
        return tipoViagem;
    }

    public void setTipoViagem(String tipoViagem) {
        this.tipoViagem = tipoViagem;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public String getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(String hospedagem) {
        this.hospedagem = hospedagem;
    }

    public String getTipoHospedagem() {
        return tipoHospedagem;
    }

    public void setTipoHospedagem(String tipoHospedagem) {
        this.tipoHospedagem = tipoHospedagem;
    }

    public String getEnderecoHospedagem() {
        return enderecoHospedagem;
    }

    public void setEnderecoHospedagem(String enderecoHospedagem) {
        this.enderecoHospedagem = enderecoHospedagem;
    }

    public String getGuiaTurismo() {
        return guiaTurismo;
    }

    public void setGuiaTurismo(String guiaTurismo) {
        this.guiaTurismo = guiaTurismo;
    }

    public String getAgenciaTransporte() {
        return agenciaTransporte;
    }

    public void setAgenciaTransporte(String agenciaTransporte) {
        this.agenciaTransporte = agenciaTransporte;
    }

    public String getCodigoTransporte() {
        return codigoTransporte;
    }

    public void setCodigoTransporte(String codigoTransporte) {
        this.codigoTransporte = codigoTransporte;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValorViagem() {
        return valorViagem;
    }

    public void setValorViagem(float valorViagem) {
        this.valorViagem = valorViagem;
    }
}
